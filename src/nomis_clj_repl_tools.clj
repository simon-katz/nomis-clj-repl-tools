(ns nomis-clj-repl-tools
  (:require [clojure.string :as str]
            [clojure.tools.namespace.move :as ctnm]))

;;;; ___________________________________________________________________________
;;;; classpath

(defn classpath []
  (str/split (System/getProperty "java.class.path")
             #":"))

;;;; ___________________________________________________________________________
;;;; move-ns-tree

(defn move-ns-tree
  "Use `clojure.tools.namespace.move` to move a namespace tree."
  [old-sym new-sym source-path dirs]
  (doseq [ns-name (->> (all-ns)
                       (map ns-name)
                       (map name)
                       (filter #(clojure.string/starts-with? %
                                                             (name old-sym))))]
    (let [new-ns-name (clojure.string/replace ns-name
                                              (name old-sym)
                                              (name new-sym))]
      (print "Moving" ns-name "to" new-ns-name "... ")
      (ctnm/move-ns (symbol ns-name)
                    (symbol new-ns-name)
                    source-path
                    dirs)
      (println "Done"))))

;;;; ___________________________________________________________________________
;;;; move-ns-dev-src-test
;;;; move-ns-tree-dev-src-test

(defn move-ns-dev-src-test [old-sym new-sym source-path]
  (ctnm/move-ns old-sym new-sym source-path ["dev" "src" "test"]))

(defn move-ns-tree-dev-src-test [old-sym new-sym source-path]
  (move-ns-tree old-sym new-sym source-path ["dev" "src" "test"]))
