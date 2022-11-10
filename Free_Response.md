## Time Results:

### Clojure
<ins>Sorted<ins>
* Quick - 2012ms
* Merge - 6881ms
* Built - 100ms

<ins>Reverse<ins>
* Quick - 4121ms
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
In terms of the difference in the sorted input of quick sort when compared to Python to Clojure, Clojure is about 2-3 times faster than Python even with the same sort of random pivot implementation. This could boil down to some language-specific difference since the implementation is the same but for example, Clojure uses different functions and whatnot versus Python. When it came to merge sort, Python was around 2 times faster than Clojure.

When it came to the reverse order it was pretty much the same comparison. Quick sort within Clojure was faster than python on the reversed list while python was just slightly faster than Clojure when using merge sort.

To be honest, I wasn’t sure what to expect when it came to the overall time taken to execute these functions. From taking CS 460 I knew that both of these functions had an average time complexity of n log n, however when it came to the time difference on a language-specific level I’m uninformed.
  
One unexpected thing was that merge sort was quicker in Python while Quicksort was quicker in Clojure. This was surprising because I would assume that one language would have all the algorithms faster than the other but it seems it was split this time. This could be for several reasons such as the Clojure-specific time complexity of conj vs. concat and the intricacies of recur vs. just calling the function. Furthermore, you have Python which can use list comprehension while Clojure relies on filter. It's the small things like this that I believe could be one of many culprits in these time discrepancies

I touched on the performance of the function above but what I can say about the ease of implementation, Python was a lot easier for several reasons. The main reason was that I’m currently enrolled in CS 460 Algorithms and I just implemented these functions a few weeks ago. On top of that, there are tons of resources for python implementations as well as it’s generally easier to write python code as it's more forgivable. On the other hand, Clojure I still struggle with quite a bit since I haven’t fully mastered the functional programming thought process and there aren’t as many resources out there. 

## Part 7
There were some exciting findings while exploring the built-in sorting functions in both Python and Clojure. First and foremost, when comparing the built-in sorting function in python versus merge and quick was no contest. It was hundreds of times faster when using the built-in sorting function. Next, when comparing the built-in sorting function in Clojure versus merge and quick were both the same. Clojure's built-in sort was extremely fast, only taking around 100ms which was about 20x to 60x times more quickly than quicksort and mergesort. Finally, exploring the cross-language comparison of the built-in functions, Python is around 10 times faster than Clojure.
