(ns assingment4-clj.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;; Part 1
(defn quick-sort
  "Merge Sort: Recursive Sorting Algorithm"
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
      (concat (quick-sort left) [pivot] (quick-sort right)))))

;; Part 2
(defn merge-sort
  "Quick Sort: Recursive Sorting Algorithm"
  [list]
  ;; Base case of length == 1 or 0
  (if (< (count list) 2)
    list
    ;; Break the list into two halves
    (let [[left right] (split-at (/ (count list) 2) list)]
      ;; Merge procedure
      (loop
       [temp []
        left (merge-sort left)
        right (merge-sort right)]
        (cond 
          (empty? left) (concat temp right)
          (empty? right) (concat temp left)
          ;; Add the smaller of the left and right halves and recur
          :else (if (<= (first left) (first right))
                  (recur (conj temp (first left)) (rest left) right)
                  (recur (conj temp (first right)) left (rest right))))))))

;; Part 3
(defn test-merge-sort
  [list]
  (if (= (merge-sort list) (sort list))
    "Merge-Sort sorted the list!"
    "Merge-Sort failed to sort the list"))

(test-merge-sort [2 6 1 9 1])

(defn test-quick-sort
  [list]
  (if (= (quick-sort list) (sort list))
    "Quick-Sort sorted the list!"
    "Quick-Sort failed to sort the list"))

(test-quick-sort [2 6 1 9 1])




(time (do (quick-sort (range 1000000)) nil))
