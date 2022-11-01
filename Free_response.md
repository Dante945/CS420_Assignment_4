## Time Results:

### Clojure
<ins>Sorted<ins>
* Quick - 0.5ms
* Merge - 6881ms
* Built - 100ms

<ins>Reverse<ins>
* Quick - 53ms
* Merge - 6800ms
* Built - 100ms

### Python
<ins>Sorted<ins>
* Quick - 6800ms
* Merge - 3352ms
* Built - 9ms

<ins>Reverse<ins>
* Quick - 8339ms
* Merge - 3371ms
* Built - 9ms

## Part 6
In terms of the difference in the sorted input of quick sort when compared to Python to Clojure, it's not even close. The use of the lazy-cat function results in Clojure being over 10,000x faster on the sorted input. When it came to merge sort, Python was around 2 times faster than Clojure.

When it came to the reverse order it was pretty much the same comparison. Quick sort within Clojure was tremendously faster than python on the reversed list while python was just slightly faster than Clojure when using merge sort

To be honest, I wasn’t sure what to expect when it came to the overall time taken to execute these functions. From taking CS 460 I knew that both of these functions had an average time complexity of n log n, however when it came to the time difference on a language-specific level I’m uninformed.

One unexpected thing was how much faster the implementation of quick sort was in Clojure compared to all of these other comparison-based sorting algorithms. Although they share the same time complexity, they differed greatly in the time taken to execute.

I touched on the performance of the function above but what I can say about the ease of implementation, Python was a lot easier for several reasons. The main reason was that I’m currently enrolled in CS 460 Algorithms and I just implemented these functions a few weeks ago. On top of that, there are tons of resources for python implementations as well as it’s generally easier to write python code as it's more forgivable. On the other hand, Clojure I still struggle with quite a bit since I haven’t fully mastered the functional programming thought process and there aren’t as many resources out there. 

## Part 7
There were some interesting findings while exploring the built-in sorting functions in both Python and Clojure. First and foremost, when comparing the built-in sorting function in python versus merge and quick was no contest. It was hundreds of times faster when using the built-in sorting function. Next, when comparing the built-in sorting function in Clojure versus merge and quick were both different. It was much faster than merge sort but quick sort in Clojure is still unmatched, being on average 100 times faster than the built-in sorting function. Finally, exploring the cross-language comparison of the built-in functions, Python is around 10 times faster than Clojure.
