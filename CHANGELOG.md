# Changelog
All notable changes to this project will be documented in this file.

## [1.100.0]

### Breaking Changes

- **`AbstractExportPost`** — `scope()` renamed to `getScopeAsString()`, `format()` renamed to `getFormatAsString()`.
  Update any callers of the old method names.

- **`ApiShareInfo.sharedItemName`** — field type corrected from `Long` to `String`.
  Update any code that stores or passes `getSharedItemName()` as a `Long`.

- **`FieldPut`** — locally-shadowed `content` field removed; `FieldPut` now inherits `content` from `FieldPost`.
  The two-arg constructor `FieldPut(String content, Long id)` is preserved so existing callers still compile.
  However, `equals()`/`hashCode()` no longer compare two separate `content` fields, and any code that set
  the shadowed field via reflection must switch to the inherited field.

- **`ActivitySearchResult`, `DocumentSearchResult`, `FileSearchResult`, `FormSearchResult`, `ShareSearchResult`** —
  changed from `@Value` (immutable, all-args constructor) to `@Data @NoArgsConstructor` (mutable, no all-args constructor).
  These are response POJOs and should not be constructed directly, but any code using the `@Value`-generated
  constructor will no longer compile.

- **`User`** — replaced `@Value @NoArgsConstructor` with `@Data @NoArgsConstructor`.
  Any code using positional construction (`new User(id, username, …)`) will no longer compile.

- **`ISO8601DateSerialiser`** — dates are now always serialised in UTC (previously used the JVM default timezone).
  A `Date` value whose local-timezone calendar date differs from its UTC date will now serialise differently.
  Ensure all `Date` values passed to `DateFormField` represent midnight UTC if exact date identity matters.

### Added

- `UserInfo` — full user information returned by the sysadmin user-listing endpoint.
- `UserSearchResult` — paginated wrapper for `UserInfo` lists.
- `GroupSearchResult` — paginated wrapper for `GroupInfo` lists returned by the sysadmin group-listing endpoint.
- `SharePermissionUpdate` — request body for `PUT /share` (update permission of an existing share).
- `DocumentShares` — response for `GET /share/document/{id}`; contains `directShares` and `notebookShares` as `List<DocumentShareEntry>`.
- `DocumentShareEntry` — a single entry within a `DocumentShares` response.

### Fixed

- `@JsonIgnoreProperties(ignoreUnknown = true)` added to all response POJOs. Prevents `UnrecognizedPropertyException`
  when the server adds new fields in future releases.
- `ISO8601DateSerialiser` — replaced per-call `SimpleDateFormat` with a thread-safe static `DateTimeFormatter`.
- Removed stale swagger-codegen `DO NOT EDIT` headers from 12 source files.

## [1.99.1]

### Added

- Add support for form features:
  - `AccessControl` model - Represents permissions for view/edit access to forms
  - `Form` model - Complete form definition including field definitions
  - `FormField` abstract model – for all form field types
  - `FormState` enum - Enumeration for form publishing states (NEW, PUBLISHED, UNPUBLISHED, OLD)
  - `ChoiceFormField` model - Checkbox field with multiple selection support
  - `DateFormField` model - Date input field with min/max validation
  - `NumberFormField` model - Numeric field with range and decimal places 
  - `RadioFormField` model - Radio button field for single selection
  - `StringFormField` model - Short text input field (max 255 characters)
  - `TextFormField` model - Long text field supporting HTML content
  - `TimeFormField` model - Time input field storing millisecond values

### Changed

- Enhanced `FormInfo` model with additional properties:
  - Added `formState` property for tracking publishing status
  - Added `accessControl` property for permission management
  - Added `tags` property for form categorization
  - Added `iconId` property for form visual identification

## [1.99.0]
- switch from rspace-os-parent to rspace-parent as parent pom

## [1.98.1]

### Added
- Introduced support for a document:
  - `MoveRequest` model

### Changed
- Upgrade dependency: lombok 1.18.42.

## [1.98.0]

### Added
- Introduced support for Inventory features:
  - `Barcode` model
  - `TagInfo` model
  - `RecordInfo` model
  - `SharedWith` model
- Added the ability to represent sharing mode, barcodes, and tags for Inventory.

## [1.97.0]

- Support newly added audit (activity) actions: DUPLICATE and RENAME
- Update list of possible audit (activity) domains

## [1.95.0]
- Compile with java 17
- Switch to using parent pom from rspace-os-parent project
- Change <groupId> of produced artifact to from com.researchspace to com.github.rspace-os

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
