(ns nomis-clj-repl-tools
  (:require [clojure.string :as str]
            [clojure.tools.namespace.move :as ctnm]))

;;;; ___________________________________________________________________________
;;;; classpath

(defn classpath []
  (str/split (System/getProperty "java.class.path")
             #":"))

;;;; ___________________________________________________________________________
;;;; ns-names-matching-re

(defn ns-names-matching-re [re]
  (->> (all-ns)
       (map ns-name)
       (map str)
       (filter #(re-find re %))
       sort))

;;;; ___________________________________________________________________________
;;;; move-ns-tree

(defn move-ns-tree
  "Use `clojure.tools.namespace.move` to move a namespace tree.
  `old-sym` is a namespace prefix such as `a.b.c`.
  Move namespaces named `a.b.c.d1`, `a.b.c.d2`, `a.b.c.d3.e1`, `a.b.c.d3.e2` etc.
  NB The namespaces must already be loaded."
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
      (try (do (ctnm/move-ns (symbol ns-name)
                             (symbol new-ns-name)
                             source-path
                             dirs)
               (println "Done"))
           (catch Exception
               e
             (println (format "\n    Warning: %s: %s"
                              (.getName (type e))
                              (.getMessage e))))))))

;;;; ___________________________________________________________________________
;;;; move-ns-dev-src-test
;;;; move-ns-tree-dev-src-test

(defn move-ns-dev-src-test [old-sym new-sym source-path]
  (ctnm/move-ns old-sym new-sym source-path ["dev" "src" "test"]))

(defn move-ns-tree-dev-src-test [old-sym new-sym source-path]
  (move-ns-tree old-sym new-sym source-path ["dev" "src" "test"]))
