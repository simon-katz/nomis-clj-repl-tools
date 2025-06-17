(ns nomis-clj-repl-tools
  (:require [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.tools.namespace.move :as ctnm]))

;;;; ___________________________________________________________________________
;;;; classpath

(defn classpath []
  (str/split (System/getProperty "java.class.path")
             #":"))

;;;; ___________________________________________________________________________
;;;; ns-names

(defn ns-names
  []
  (map ns-name (all-ns)))

;;;; ___________________________________________________________________________
;;;; ns-names-matching-re

(defn ns-names-matching-re [re]
  (filter #(re-find re (name %))
          (ns-names)))

;;;; ___________________________________________________________________________
;;;; move-ns-tree

(defn move-ns-tree
  "Use `clojure.tools.namespace.move` to move a namespace tree.
  `old-sym` is a namespace prefix such as `a.b.c`.
  Move namespaces named `a.b.c.d1`, `a.b.c.d2`, `a.b.c.d3.e1`, `a.b.c.d3.e2` etc.
  NB The namespaces must already be loaded."
  [old-sym new-sym source-path dirs]
  (doseq [ns-name (->> (ns-names)
                       (map name)
                       (filter #(.startsWith % (name old-sym)))
                       sort)]
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
;;;; move-ns-++
;;;; move-ns-tree-++

(def often-used-src-and-test-dirs
  ["dev" "src" "test" "src/clj" "test/clj"])

(defn move-ns-++ [old-sym new-sym source-path]
  (ctnm/move-ns old-sym new-sym source-path often-used-src-and-test-dirs))

(defn move-ns-tree-++ [old-sym new-sym source-path]
  (move-ns-tree old-sym new-sym source-path often-used-src-and-test-dirs))

;;;; ___________________________________________________________________________
;;;; Uptime

(defn uptime-ms []
  (-> (java.lang.management.ManagementFactory/getRuntimeMXBean)
      .getUptime))

(defn uptime-seconds []
  (-> (uptime-ms)
      (/ 1000)
      float))

(defn ^:private quot-rem [n d] [(quot n d) (rem  n d)])

(def ^:private ms-in-s 1000)
(def ^:private ms-in-m (* ms-in-s 60))
(def ^:private ms-in-h (* ms-in-m 60))
(def ^:private ms-in-d (* ms-in-h 24))

(defn ms->string [ms]
  (let [[d spare-ms] (quot-rem ms ms-in-d)
        [h spare-ms] (quot-rem spare-ms ms-in-h)
        [m spare-ms] (quot-rem spare-ms ms-in-m)
        [s spare-ms] (quot-rem spare-ms ms-in-s)]
    (pp/cl-format nil "~d days ~2,'0d:~2,'0d:~2,'0d.~3,'0d"
                  d h m s spare-ms)))

(defn uptime-string []
  (ms->string (uptime-ms)))

(comment
  [(uptime-ms)
   (uptime-seconds)
   (uptime-string)])
