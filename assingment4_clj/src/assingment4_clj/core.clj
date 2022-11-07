(ns assingment4-clj.core
  (:gen-class) 
  (:require [clojure.test :refer [deftest is testing]]))

;; Part 1
(defn quicksort
  "Divide and Conquer algorithm that uses a pivot"
  [coll]
  (if (< (count coll) 2)
    coll
    (let [pivot (first coll)
          left (filter #(< % pivot) (rest coll))
          right (filter #(<= pivot %) (rest coll))]
      (lazy-cat (quicksort left) [pivot] (quicksort right)))))

;; Part 2
(defn mergesort
  "Divide and Conquer algorithm that merges two halves"
  [coll]
  (if (< (count coll) 2)
    coll
    (let [[left right] (split-at (/ (count coll) 2) coll)]
      ;; Merge procedure
      (loop
       [temp []
        left (mergesort left)
        right (mergesort right)]
        (cond
          (empty? left) (lazy-cat temp right)
          (empty? right) (lazy-cat temp left)
          :else (if (<= (first left) (first right))
                  (recur (conj temp (first left)) (rest left) right)
                  (recur (conj temp (first right)) left (rest right))))))))
;; Extra
(defn quicksortv2
  "Divide and Conquer algorithm that uses a random pivot"
  [coll]
  (if (<= (count coll) 1)
    coll
    (let [rand_idx (rand-int (count coll))
          rand_elem (nth coll rand_idx)
          ;; Remove random pivot from coll
          list (keep-indexed #(if (not= %1 rand_idx) %2 nil) coll) 
          left (filter #(< % rand_elem) list)
          right (filter #(<= rand_elem %) list)]
      (concat (quicksortv2 left) [rand_elem] (quicksortv2 right)))))

;; Part 3
(deftest mergesort?
  (testing "Normal case"
    (is (= [1 2 2 3 4 6] (mergesort [2 1 4 6 3 2])))
    (is (= [-2 -1 2 4 5 10] (mergesort [10 -2 5 4 2 -1])))
    (is (= [1 1 2 6 9] (mergesort [2 6 1 9 1])))
    (is (= [1 2 3 4 5] (mergesort [5 4 3 2 1])))))
(mergesort?)

(deftest quicksort?
  (testing "Normal case"
    (is (= [1 2 2 3 4 6] (quicksort [2 1 4 6 3 2])))
    (is (= [-2 -1 2 4 5 10] (quicksort [10 -2 5 4 2 -1])))
    (is (= [1 1 2 6 9] (quicksort [2 6 1 9 1])))
    (is (= [1 2 3 4 5] (quicksort [ 5 4 3 2 1])))))
(quicksort?)

;; Extra
(deftest quicksortv2?
  (testing "Normal case"
    (is (= [1 2 2 3 4 6] (quicksortv2 [2 1 4 6 3 2])))
    (is (= [-2 -1 2 4 5 10] (quicksortv2 [10 -2 5 4 2 -1])))
    (is (= [1 1 2 6 9] (quicksortv2 [2 6 1 9 1])))
    (is (= [1 2 3 4 5] (quicksortv2 [5 4 3 2 1])))))
(quicksortv2?)


;; Part 5

;; Timing quicksort on 1 million sorted numbers
(time (do (quicksort (range 1000000)) nil))

;; Timing mergesort on 1 million sorted numbers
(time (do (mergesort (range 1000000)) nil))

;; Timing quicksort on 1 million reversed numbers
(time (do (quicksort (reverse (range 1000000))) nil))

;; Timing mergesort on 1 million reversed numbers
(time (do (mergesort (reverse (range 1000000))) nil))

;; Extra 

;; Timing quicksortv2 on 1 million sorted numbers
(time (do (quicksortv2 (range 1000000)) nil))

;; Timing quicksortv2 on 1 million reversed numbers
(time (do (quicksortv2 (reverse (range 1000000))) nil))

;; Part 7

;; Timing built-in on 1 million sorted numbers
(time (do (sort (range 1000000)) nil))

;; Timing built-in on 1 million reversed numbers
(time (do (sort (reverse (range 1000000))) nil))