# Changelog
All notable changes to this project will be documented in this file.

## [1.99.1]

### Added

- Add support for form features:
  - `AccessControl` model - Represents permissions for view/edit access to forms
  - `Form` model - Complete form definition including field definitions
  - `FormField` abstract model – for all form field types
  - `FormState` enum - Enumeration for form publishing states (NEW, PUBLISHED, UNPUBLISHED, OLD)
  - `ChoiceFormField` model - Checkbox field with multiple selection support
  - `DateFormField` model - Date input field with min/max validation
  - `NumberFormField` model - Numeric field with range and decimal place 
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
- Introduced support for document:
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
