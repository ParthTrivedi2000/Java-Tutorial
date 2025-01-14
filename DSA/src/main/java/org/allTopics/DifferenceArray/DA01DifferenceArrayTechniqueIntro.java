package org.allTopics.DifferenceArray;

/*
Famous technique used to efficiently apply range updates an array. It helps to do multiple updates in constant time.

So this technique is ideal for range modification problem.

Let's tak an example to understand well.
for example, you have been given nums array. nums = {0,0,0,0,0} and you have been queries array which consists of
starting index, ending index and value you need to modify.
queries= [(1,3,2),(2,4,3),(0,2,-2)]

so here you can see, you have been asked to modify the array ranges with certain values. Now as a bruteforce approach
it costs O(N^2). but with diff. array technique it optimises with O(N).

so what you need to do is, first you have to create the diff array. means in the original array you have to do
the following things. with iteration of each query inside queries array, for starting index you have to place
value in the array, and on the ending index + 1 you have to put -ve value.

And once we did above step, then we should perform cumulative sum across the array. and that will be your ans.

Step-1:-
       idx =  0 1 2 3 4
(1,3,2) ---> {0,2,0,0,-2}     (here startIndex=1, endIndex=3 hence need to put +ve val on idx 1 and -ve val on idx 3+1=4)
(2,4,3) ---> {0,2,3,0,-2}
(0,2,-2) ---> {-2,2,3,2,-2}

------------------------------------------
step-2:-
cumulativeSum --> {-2,0,3,5,3}

above ans will be your ans.

- generically :-
    Step-1:-
    [L,R,val] --> arr[L] += x,
                  arr[R+1] -= x (if R+1<n)
    Step-2:- Cumulative sum

You might have question like, we are already having "Segment Tree" for that, why not to use it?
Bec here if you see, how simple this technique is. means just put elems and take cumulative sum.
in segment tree, if you think we need to do build 4*n array and etc etc so much complex things. So

1) Difference Array is easier to implement.
2) Space complexity:- Difference Array:- O(N)
                      Segment Tree :- O(4*N)
3) Time complexity for each Range update,
- Difference Array = O(1) {bec arr[L] += x, arr[R+1] -= x}
then you perform single pass O(n) to apply all the changes.
- In segment tree, range update with each iteration = O(logN)

4) When to use which ??
- Difference Array:-
    - Best suited for problems where you need to perform multiple range updates ( like adding or subtracting a value
    over a range).
    - when you don't need to query the array frequently after updates.
    - Highly efficient when you only need to apply a sequence of range operations and get done.
    (means here after performing range queries in the original array, there is no requirement of update any value of
    array)
- Segment Tree :-
    - When you need both range Queries and updates frequently.

 */

public class DA01DifferenceArrayTechniqueIntro {
}
