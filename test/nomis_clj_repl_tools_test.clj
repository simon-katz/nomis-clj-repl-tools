(ns nomis-clj-repl-tools-test
  (:require
   [clojure.test :refer [deftest is]]
   [nomis-clj-repl-tools :as sut]))

(def ms-in-s 1000)
(def ms-in-m (* ms-in-s 60))
(def ms-in-h (* ms-in-m 60))
(def ms-in-d (* ms-in-h 24))

(deftest ms->string-test
  (is (= "0 days 00:00:00.000" (sut/ms->string 0)))
  (is (= "0 days 00:00:01.000" (sut/ms->string ms-in-s)))
  (is (= "0 days 00:01:00.000" (sut/ms->string ms-in-m)))
  (is (= "0 days 01:00:00.000" (sut/ms->string ms-in-h)))
  (is (= "1 days 00:00:00.000" (sut/ms->string ms-in-d)))
  (is (= "1 days 01:01:01.001" (sut/ms->string (+ ms-in-d
                                                  ms-in-h
                                                  ms-in-m
                                                  ms-in-s
                                                  1))))
  (is (= "5 days 04:03:02.001" (sut/ms->string (+ (* 5 ms-in-d)
                                                  (* 4 ms-in-h)
                                                  (* 3 ms-in-m)
                                                  (* 2 ms-in-s)
                                                  1))))
  (is (= "123 days 23:59:59.999" (sut/ms->string (+ (* 123 ms-in-d)
                                                    (* 23 ms-in-h)
                                                    (* 59 ms-in-m)
                                                    (* 59 ms-in-s)
                                                    999))))
  (is (= "124 days 00:00:00.000" (sut/ms->string (+ (* 123 ms-in-d)
                                                    (* 23 ms-in-h)
                                                    (* 59 ms-in-m)
                                                    (* 59 ms-in-s)
                                                    999
                                                    1)))))
