# Changelog
All notable changes to this project will be documented in this file.

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
