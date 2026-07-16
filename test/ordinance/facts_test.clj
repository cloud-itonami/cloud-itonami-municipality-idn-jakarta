(ns ordinance.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest jakarta-has-spec-basis
  (let [sb (facts/spec-basis "jakarta")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://jdih.jakarta.go.id/") sb))
    (is (every? :ordinance/number sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "surabaya")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["jakarta" "surabaya"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["surabaya"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["jakarta.perda-4-2019-pengelolaan-sampah"]
         (mapv :ordinance/id (facts/by-topic "jakarta" :waste-management))))
  (is (empty? (facts/by-topic "jakarta" :labor)))
  (is (empty? (facts/by-topic "surabaya" :waste-management))))
