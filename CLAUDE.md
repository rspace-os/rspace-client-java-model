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

## Testing rules

All tests use **JUnit 5** (`org.junit.jupiter.api.Test`). Do not use JUnit 4.

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
