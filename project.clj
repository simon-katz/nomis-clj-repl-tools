(defproject nomis-clj-repl-tools "0.1.5"
  :description "Clojure REPL tools"
  :url "https://github.com/simon-katz/nomis-clj-repl-tools"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.namespace "1.0.0"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[midje "1.9.9"]]
                   :plugins [[lein-midje "3.2.1"]]}})
