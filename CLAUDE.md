# rspace-client-java-model

Pure POJO library. No HTTP. No Spring. No business logic.
Provides request and response model classes for the RSpace REST API, consumed by:
- `rspace-api-acceptance` — the API client and acceptance test repo
- `rspace-playwright-java` — the UI E2E test framework (via `ApiUtils`)

**Cross-repo rule:** Any change to this library that renames, removes, or changes the type of a field or method must also be checked (and fixed if broken) in both `rspace-api-acceptance` and `rspace-playwright-java` before the PR is merged.

---

## Module layout

```
src/main/java/
  com.researchspace.api.clientmodel/           ← ELN request + response POJOs
  com.researchspace.api.clientmodel.inventory/ ← Inventory base types only
  com.researchspace.api.jackson/               ← Custom Jackson serialisers

src/test/java/
  com.researchspace.api.clientmodel/           ← Unit tests: serialisation + builder contracts
```

### Inheritance hierarchy — never instantiate base classes directly

```
Linkable                     ← _links list + getLinkByType()
  └── PaginatedResultList    ← totalHits, pageNumber, pageSize
  └── IdentifiableNameable   ← id, globalId, name
        └── DocumentInfo     ← created, lastModified, tags, form, owner, parentFolderId
              └── Document   ← fields: List<Field>
        └── FormInfo         ← stableId, version, formState, accessControl, tags
              └── Form       ← fields: List<FormField>
        └── GroupInfo        ← type, sharedFolderId, members
        └── ApiFile          ← contentType, size, caption, created, version
        └── RecordInfo (inventory) ← description, tags, sharingMode, barcodes
```


## Lombok rules

- **Response POJOs**: `@Data @NoArgsConstructor` (+ `@EqualsAndHashCode(callSuper=true) @ToString(callSuper=true)` for subclasses)
- **Request POJOs**: `@Data @Builder @NoArgsConstructor @AllArgsConstructor`
- **Abstract base classes**: `@Data @NoArgsConstructor @SuperBuilder`
- **Search result wrappers**: `@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=true) @ToString(callSuper=true)`

Do not invent new Lombok combinations not listed here.

**Never use `@Value` on a class that Jackson needs to deserialise.** `@Value` makes all fields `final` with no setters and generates an all-args constructor; Jackson cannot deserialise into it without a custom deserialiser.

**`@Singular`** on a `List<T>` field in a `@Builder` class enables single-item chaining:
```java
DocumentPost.builder()
    .field(new FieldPost("content1"))
    .field(new FieldPost("content2"))
    .build();
```
Used in: `DocumentPost.fields`, `GroupPost.users`, `ActivitySearchQuery.domains/actions/usernames`, `SharePost.itemsToShare/groups/users`.

---

## Jackson rules

### `@JsonIgnoreProperties(ignoreUnknown = true)`

Add this to every response POJO. `IdentifiableNameable` already carries it, so its subclasses inherit it — but also add it explicitly to non-hierarchy response classes (`User`, `Status`, `ApiShareInfo`, etc.) for clarity.

### `@JsonProperty` on field name mismatches

Use `@JsonProperty("serverFieldName")` when the Java field name differs from what the server sends. Example: `MoveRequest.recordId` is annotated `@JsonProperty("docId")` because the server API field is `docId`.

### `ISO8601DateSerialiser` — for date fields sent TO the server

`DateFormField` and `DateFieldPost` use `@JsonSerialize(using = ISO8601DateSerialiser.class)` to serialise `Date` values as `"yyyy-MM-dd"` strings in UTC. Use this serialiser for any new date field the server expects in that format. Do not use it for response date fields — those deserialise as standard epoch millis.

Dates are always serialised in UTC. Callers must ensure the logical date they intend to send matches the UTC date of the `Date` instance (e.g. set to midnight UTC).

### `@JsonProperty("_links")` is on `Linkable`

Do not re-annotate `_links` in subclasses.

### `@JsonPropertyOrder` — for types in Swagger examples

`Form`, `FormInfo`, and all `FormField` subclasses use `@JsonPropertyOrder` so serialised JSON matches documentation order. Add it to new types that will appear in API docs or test fixtures.

---

## Testing rules

All tests use **JUnit 5** (`org.junit.jupiter.api.Test`). Do not use JUnit 4.

Use **British spelling** throughout: `serialised`, `deserialised`, `initialised`, etc. This is consistent with the class name `ISO8601DateSerialiser` and all existing test method names.

### Two test patterns

**JSON fixture roundtrip** (via `AbstractModelTest`) — use for response POJOs:
```java
MyType result = readFileToClass(new File("src/test/resources/MyType.json"), MyType.class);
assertEquals("expectedValue", result.getSomeField());
```

**Serialisation roundtrip** (inline `ObjectMapper`) — use for request POJOs and serialisation contracts:
```java
ObjectMapper om = new ObjectMapper();
String json = om.writeValueAsString(myObject);
MyType deserialised = om.readValue(json, MyType.class);
assertEquals(expected, deserialised.getSomeField());
```

### Testing `@JsonIgnoreProperties` correctly

To verify that `@JsonIgnoreProperties(ignoreUnknown = true)` works on a class, use a plain `new ObjectMapper()` with no mapper-level configuration changes. If you disable `FAIL_ON_UNKNOWN_PROPERTIES` on the mapper instead, the test doesn't prove the annotation works:

```java
// Correct — tests the annotation
String json = "{\"id\":1,\"unknownFutureField\":\"x\"}";
MyType obj = new ObjectMapper().readValue(json, MyType.class);

// Wrong — tests the mapper setting, not the annotation
MyType obj = new ObjectMapper()
    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    .readValue(json, MyType.class);
```

### Every new POJO needs at least one test

Minimum: deserialise from a representative JSON fixture and assert on the fields. If the class has builder methods (`addField()`, `appendContent()`), test those too.

### JSON fixtures

Location: `src/test/resources/`. Every `PaginatedResultList` fixture must include `totalHits`, `pageNumber`, and `pageSize`.

Existing fixtures: `Document.json`, `DocumentSearchResult.json`, `DocumentSearchQuery.json`, `ActivitySearchResult.json`, `FileSearchResult.json`, `File.json`, `Folder.json`, `FormSearchResult.json`, `Form.json`, `FolderTreeItemListing.json`, `GroupSearchResult.json`, `User.json`, `UserInfo.json`, `UserSearchResult.json`, `completedJob.json`.

---

## Adding a new class — checklist

1. Decide which category: response POJO, request POJO, base class, or inventory base
2. Choose Lombok annotations from the taxonomy table — do not invent new combinations
3. Add `@JsonIgnoreProperties(ignoreUnknown = true)` if it is a response POJO
4. Add a JSON fixture in `src/test/resources/` (or use a serialisation roundtrip test for request POJOs)
5. Write a unit test asserting on fields
6. Verify field names against the server source before adding fields not in the current Swagger: `https://github.com/rspace-os/rspace-web/tree/main/src/main/java/com/researchspace/api/v1`
7. Check `rspace-api-acceptance` and `rspace-playwright-java` for any callers affected by the change

---

## Constraints

- No Spring, RestTemplate, or HTTP dependencies in this module
- No concrete inventory response types (`RSSample`, `RSInvContainer`, etc.) — those belong in `rspace-api-acceptance`
- No `@Value` on classes that Jackson needs to deserialise
- No swagger-codegen `DO NOT EDIT` header comments — those files are manually maintained
- No `jakarta.validation` — use `javax.validation` only
- No new field on a response POJO without a test that verifies it deserialises correctly
- No new Lombok combinations not in the taxonomy table

---
