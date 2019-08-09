# nomis-clj-repl-tools

Clojure REPL tools.

**This documentation tracks the `master` branch. Consult
the relevant Git tag (e.g. `0.1.2`) if you need documentation for a
specific release.**


## Installation

Current version:

[![Clojars Project](https://img.shields.io/clojars/v/nomis-clj-repl-tools.svg)](https://clojars.org/nomis-clj-repl-tools)


## Usage

### classpath

A function that returns the classpath as a sequence of strings.

### move-ns-tree

A function that moves a namespace tree (that is, a Clojure code directory).
This entails renaming the directory and adjusting mentions of namespaces in
source files.

### move-ns-dev-src-test

A function that calls `clojure.tools.namespace.move/move-ns` with a `source-path`
arg of `["dev" "src" "test"]`.

### move-ns-tree-dev-src-test

A function that calls `move-ns-tree` with a `source-path`
arg of `["dev" "src" "test"]`.


## License

Copyright © 2018-2019 Simon Katz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
