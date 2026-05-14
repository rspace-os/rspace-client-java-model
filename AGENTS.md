# AGENTS.md — rspace-client-java-model

> Single source of truth for AI agents and human contributors.
> When the agent produces incorrect output, make the rule more explicit here.
> Never patch via one-off prompt instructions.

---

## Purpose

Pure POJO library. No HTTP. No Spring. No business logic.
Provides request and response model classes for the RSpace REST API used by:
- `rspace-api-acceptance` — the API client and acceptance test repo
- `rspace-playwright-java` — the UI E2E test framework (via `ApiUtils`)

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

---

## Class taxonomy — know which pattern applies before creating a new class

### Response POJOs (what the server sends back)

Used for deserialisation. Must survive unknown fields from future server releases.

| Class | Extends | Lombok | Extra |
|---|---|---|---|
| `Document` | `DocumentInfo` | `@Data @NoArgsConstructor` | — |
| `DocumentInfo` | `IdentifiableNameable` | `@Data @NoArgsConstructor` | — |
| `Folder` | `IdentifiableNameable` | `@Data @NoArgsConstructor` | — |
| `ApiFile` | `IdentifiableNameable` | `@Data @NoArgsConstructor` | — |
| `Form` | `FormInfo` | `@Data @NoArgsConstructor @SuperBuilder` | `@JsonPropertyOrder` |
| `FormInfo` | `IdentifiableNameable` | `@Data @NoArgsConstructor @SuperBuilder` | `@JsonPropertyOrder` |
| `GroupInfo` | `IdentifiableNameable` | `@Data @NoArgsConstructor` | — |
| `User` | — | `@Data @NoArgsConstructor` | — |
| `ActivitySearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |
| `DocumentSearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |
| `FileSearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |
| `FormSearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |
| `ShareSearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |
| `UserInfo` | `IdentifiableNameable` | `@Data @NoArgsConstructor` | — |
| `UserSearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |
| `GroupSearchResult` | `PaginatedResultList` | `@Data @NoArgsConstructor` | — |

### Request POJOs (what the client sends to the server)

Used for serialisation only. `@Builder` pattern for clean construction at call sites.

| Class | Lombok |
|---|---|
| `DocumentPost` | `@Data @Builder` + `@Singular` on `fields` |
| `FolderPost` | `@Data @Builder` |
| `FormPost.Form` (inner) | `@Data @Builder` + `@Singular` on `fields` |
| `GroupPost` | `@Data @AllArgsConstructor @NoArgsConstructor @Builder` + `@Singular` on `users` |
| `UserPost` | `@Data @AllArgsConstructor @NoArgsConstructor @Builder` |
| `SharePost` | `@Data @Builder @AllArgsConstructor @NoArgsConstructor` |
| `MoveRequest` | `@Data @NoArgsConstructor @AllArgsConstructor @Builder` |

### Inheritance base classes — never instantiate directly

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

### Form field hierarchy — polymorphic deserialisation via `@JsonTypeInfo`

`FormField` is abstract and uses `@JsonSubTypes` to deserialise by `"type"` property.
Concrete types: `StringFormField`, `TextFormField`, `NumberFormField`,
`RadioFormField`, `ChoiceFormField`, `DateFormField`, `TimeFormField`.

When deserialising a `Form` containing fields, Jackson dispatches on the `"type"` string.
The discriminator values are capitalised: `"String"`, `"Text"`, `"Number"`, `"Radio"`,
`"Choice"`, `"Date"`, `"Time"`.

`FormPost.FormFieldPost` (inner class hierarchy) is the **request** counterpart —
it has the same field names but `@Builder` constructors and no `@JsonSubTypes`.
The two hierarchies are parallel — never mix them.

### Inventory types — split across two packages

```
com.researchspace.api.clientmodel.inventory/   ← in THIS repo
  RecordInfo     ← abstract base for all inventory items
  Barcode        ← barcode attached to an item
  SharedWith     ← group-level sharing details
  TagInfo        ← ontology tag

com.researchspace.api.acceptance.invmodel/     ← in rspace-api-acceptance
  RSSample       extends RecordInfo
  RSInvContainer extends RecordInfo
  Subsample      extends RecordInfo
  SamplePost     extends RecordInfo
  ApiSampleTemplate
  ... (all concrete inventory types)
```

Never put concrete inventory response types (`RSSample`, `RSInvContainer` etc.)
in this repo — they belong in `rspace-api-acceptance`.
Only add to `inventory/` if it is a base type used by multiple concrete classes.

---

## Lombok rules

**Response POJOs** use: `@Data @NoArgsConstructor` (+ `@EqualsAndHashCode(callSuper=true)` for subclasses)
**Request POJOs** use: `@Data @Builder @NoArgsConstructor @AllArgsConstructor`
**Abstract base classes** use: `@Data @NoArgsConstructor @SuperBuilder`
**Search result list wrappers** use: `@Data @NoArgsConstructor @EqualsAndHashCode(callSuper=true)`

### `@Value` — do not use for response POJOs

`@Value` generates an immutable class: all fields `final`, no setters, all-args constructor.
Jackson cannot deserialise into a `@Value` class without a custom deserialiser.

**Never use `@Value` on any class that Jackson needs to deserialise.**

### `@Singular` — use for list fields in request builder classes

`@Singular` on a `List<T>` field in a `@Builder` class allows single-item `.fieldName(item)`
chaining in the builder. Used in: `DocumentPost.fields`, `GroupPost.users`,
`ActivitySearchQuery.domains/actions/usernames`, `SharePost.itemsToShare/groups/users`.

```java
// Correct — @Singular allows this
DocumentPost.builder()
    .field(new FieldPost("content1"))
    .field(new FieldPost("content2"))
    .build();

// Without @Singular you'd need .fields(List.of(...))
```

---

## Jackson rules

### Always verify new fields with `AbstractModelTest.readFileToClass()`

Every new response POJO field must be verified by:
1. Finding or creating a JSON fixture in `src/test/resources/`
2. Writing a test that deserialises the fixture and asserts the field value
3. Confirming the field name matches exactly what the server returns

The `AbstractModelTest` configures Jackson with:
- `READ_ENUMS_USING_TO_STRING` — enums deserialise via `toString()` not `name()`
- `WRITE_ENUMS_USING_TO_STRING`
- `FAIL_ON_UNKNOWN_PROPERTIES` disabled

The production `BaseApiClientImpl` in `rspace-api-acceptance` configures the same
enum handling but does NOT yet disable `FAIL_ON_UNKNOWN_PROPERTIES`.

### `ISO8601DateSerialiser` — use for date fields sent TO the server

`DateFormField`, `DateFieldPost` use `@JsonSerialize(using = ISO8601DateSerialiser.class)`
to serialise `Date` values as `"yyyy-MM-dd"` strings.
Use this serialiser for any new date field that the server expects in that format.
Do not use it for response date fields — those are deserialised as standard epoch millis.

### `@JsonProperty("_links")` — already on `Linkable`

`Linkable.links` is already annotated `@JsonProperty("_links")`.
Do not re-annotate it in subclasses.

### `@JsonPropertyOrder` — use for types that appear in Swagger examples

`Form`, `FormInfo`, and all `FormField` subclasses have `@JsonPropertyOrder` so that
serialised JSON matches the Swagger documentation order. Add `@JsonPropertyOrder`
to new types that will appear in API documentation or test fixtures.

---

## Validation annotations

`@Size`, `@NotNull`, `@Pattern`, `@Min` from `javax.validation` are declared on
**request POJOs** only — they document what the server expects but are not enforced
client-side (there is no validation runner). They serve as in-code documentation.

The dependency is `javax.validation:validation-api:1.1.0.Final`. Do not upgrade to
`jakarta.validation` — this would break compatibility with Spring 5 in `rspace-api-acceptance`.

---

## Testing rules

All tests use **JUnit 5** (`org.junit.jupiter.api.Test`, `@BeforeEach`, `@AfterEach`).
This is consistent throughout the test suite — do not use JUnit 4 here.

### Two test patterns — both are in use

**JSON fixture roundtrip** (via `AbstractModelTest`):
```java
// Place fixture in src/test/resources/MyType.json
// Extend AbstractModelTest
MyType result = readFileToClass(new File("src/test/resources/MyType.json"), MyType.class);
assertNotNull(result.getSomeField());
assertEquals("expectedValue", result.getSomeField());
```

**Serialisation roundtrip** (via inline `ObjectMapper`):
```java
// Used in FormFieldTest, AccessControlTest — tests that classes serialise correctly
ObjectMapper om = new ObjectMapper();
om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
String json = om.writeValueAsString(myObject);
MyType deserialized = om.readValue(json, MyType.class);
assertEquals(expected, deserialized.getSomeField());
```

### Every new POJO needs at least one test

Minimum: a test that verifies the class can be deserialised from a representative JSON fixture.
If the class has builder methods (`addField()`, `appendContent()`, `appendFileReference()`),
test those too.

### JSON fixtures live in `src/test/resources/`

Existing fixtures: `Document.json`, `DocumentSearchResult.json`, `DocumentSearchQuery.json`,
`ActivitySearchResult.json`, `FileSearchResult.json`, `File.json`, `Folder.json`,
`FormSearchResult.json`, `Form.json`, `completedJob.json`.

When creating a fixture: use real server response JSON where possible, or construct
a minimal valid JSON that exercises the fields you care about.

---

## Adding a new class

1. **Decide which category** it belongs to (response POJO, request POJO, base class, inventory base)
2. **Choose Lombok annotations** from the taxonomy table above — do not invent new combinations
3. **Add `@JsonIgnoreProperties(ignoreUnknown = true)`** on response POJOs
4. **Add a JSON fixture** in `src/test/resources/` or use serialisation roundtrip test
5. **Write a unit test** in `src/test/java/com/researchspace/api/clientmodel/`
6. **Verify against dev source** before adding fields not in the current Swagger:
   `https://github.com/rspace-os/rspace-web/tree/main/src/main/java/com/researchspace/api/v1`

---

## What the agent MUST NOT do

- Add Spring, RestTemplate, or HTTP dependencies to this module
- Add concrete inventory response types (`RSSample`, `RSInvContainer` etc.) — those belong in `rspace-api-acceptance`
- Use `@Value` on a new class that needs Jackson deserialisation
- Copy the swagger-codegen `DO NOT EDIT` header comment — those files have been edited
- Add a field to a response POJO without a corresponding test that verifies it deserialises
- Use `jakarta.validation` annotations — use `javax.validation` only
- Upgrade `validation-api` past `1.1.0.Final` without checking compatibility
- Create new Lombok annotation combinations not in the taxonomy table above

> Last updated: 2026-05-05
