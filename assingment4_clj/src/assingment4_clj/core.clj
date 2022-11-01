(ns assingment4-clj.core
  (:gen-class))

;; Part 1
(defn quicksort
  "Divide and Conquer algorithm that uses a pivot"
  [coll]
  ;; Base case of length == 1 or 0
  (if (< (count coll) 2)
    coll
    ;; Define pivot to be the first element of the collection
    (let [pivot (first coll)
          ;; left will be all elements less than the pivot
          left (filter #(< % pivot) (rest coll))
          ;; right will be all elements greater than the pivot
          right (filter #(<= pivot %) (rest coll))]
      ;; Recursively call quick-sort on left and right and combine them
      (lazy-cat (quicksort left) [pivot] (quicksort right)))))

;; Part 2
(defn mergesort
  "Divide and Conquer algorithm that merges two halves"
  [coll]
  ;; Base case of length == 1 or 0
  (if (< (count coll) 2)
    coll
    ;; Break the list into two halves
    (let [[left right] (split-at (/ (count coll) 2) coll)]
      ;; Merge procedure
      (loop
       [temp []
        left (mergesort left)
        right (mergesort right)]
        (cond
          (empty? left) (lazy-cat temp right)
          (empty? right) (lazy-cat temp left)
          ;; Add the smaller of the left and right halves and recur
          :else (if (<= (first left) (first right))
                  (recur (conj temp (first left)) (rest left) right)
                  (recur (conj temp (first right)) left (rest right))))))))

;; Part 3
(defn test-mergesort
  "Test to ensure mergesort works as intended"
  [list]
  (if (= (mergesort list) (sort list))
    "Merge-Sort sorted the list!"
    "Merge-Sort failed to sort the list"))

(test-mergesort [2 6 1 9 1])

(defn test-quicksort
  "Test to ensure quicksort works as intended"
  [list]
  (if (= (quicksort list) (sort list))
    "Quick-Sort sorted the list!"
    "Quick-Sort failed to sort the list"))

(test-quicksort [2 6 1 9 1])

;; Part 5

;; Timing quicksort on 1 million sorted numbers
(time (do (quicksort (range 1000000)) nil))

;; Timing mergesort on 1 million sorted numbers
(time (do (mergesort (range 1000000)) nil))

;; Timing quicksort on 1 million reversed numbers
(time (do (quicksort (reverse (range 1000000))) nil))

;; Timing mergesort on 1 million reversed numbers
(time (do (mergesort (reverse (range 1000000))) nil))

;; Part 7

;; Timing built-in on 1 million sorted numbers
(time (do (sort (range 1000000)) nil))

;; Timing built-in on 1 million reversed numbers
(time (do (sort (reverse (range 1000000))) nil))