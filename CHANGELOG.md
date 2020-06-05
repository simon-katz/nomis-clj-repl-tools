# Changelog

All notable changes to this project will be documented in this file.

This changelog mostly follows the conventions of [Keep a Changelog](http://keepachangelog.com/en/1.0.0/); it deviates from those conventions by not making versions and sections linkable.

This project uses [Semantic Versioning](http://semver.org/spec/v2.0.0.html). In addition, breaking changes between successive initial development versions (that is 0.y.z versions) are explicitly noted.


## Unreleased

### Added

- (nothing)

### Diffs

https://github.com/simon-katz/nomis-clj-repl-tools/compare/0.1.5...HEAD


## 0.1.5 - 2020-06-05

### Added

- Add `ns-names`.
- Add `ns-names-matching-re`.

### Changed

- Upgrade to org.clojure/tools.namespace 1.0.0.
- Rename `move-ns-dev-src-test` -> `move-ns-++`, and change files in `src/clj` and `test/clj` directories in addition to the previous `src`, `test` and `dev`.
- Rename `move-ns-tree-dev-src-test` -> `move-ns-tree-++`, and change files in `src/clj` and `test/clj` directories in addition to the previous `src`, `test` and `dev`.

### Diffs

https://github.com/simon-katz/nomis-clj-repl-tools/compare/0.1.4...0.1.5


## 0.1.4 - 2019-09-24

### Added

- Move dependency on tools.namespace from dev profile to top level.
- Upgrade dependencies.

### Diffs

https://github.com/simon-katz/nomis-clj-repl-tools/compare/0.1.3...0.1.4


## 0.1.3 - 2019-08-09

### Added

- Catch and report exceptions when trying to move files.

### Diffs

https://github.com/simon-katz/nomis-clj-repl-tools/compare/0.1.2...0.1.3



## 0.1.2 - 2018-04-29

### Changed

- Upgrade to org.clojure/tools.namespace "0.3.0-alpha4".

### Diffs

https://github.com/simon-katz/nomis-clj-repl-tools/compare/0.1.0...0.1.2


## 0.1.0 - 2018-04-29

### Added

- Add `classpath`.
- Add `move-ns-tree`.
- Add `move-ns-dev-src-test`.
