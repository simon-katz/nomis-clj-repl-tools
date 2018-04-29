(defproject nomis-clj-repl-tools "0.1.0-SNAPSHOT"
  :description "Clojure REPL tools"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [midje "1.9.1"]]
                   :plugins [[lein-midje "3.2.1"]]}})
