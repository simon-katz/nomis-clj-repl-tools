(defproject nomis-clj-repl-tools "0.1.1-SNAPSHOT"
  :description "Clojure REPL tools"
  :url "https://github.com/simon-katz/nomis-clj-repl-tools"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.11"]
                                  [midje "1.9.1"]]
                   :plugins [[lein-midje "3.2.1"]]}})
