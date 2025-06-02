package org.allTopics.DynamicProgramming;

/*
DP:- Dynamic Programming

- DP Concept:-You have to calculate the unique things only, once calculated you just have to reuse it from next time
instead of recalculating it again.
So long story short DP concept is:- Calculate all unique result once & reuse it later.

- DP can use in every Recursive problem?:-
no, Suppose for example find factorial of n is the problem statement. --> Then it's recursive tree be like
  fact(5)
    |
  fact(4)
    |
  fact(3)
    |
  fact(2)
    |
  fact(1) {hit the base case}

- So here if you can see you are hitting each function call once only, so you have to calculate it and here if you
create any DP array and if you store result into it, then it doesn't make any sense bec anyhow we are not using it
in future or later function calls. So at this place it is just waste of space to create DP and store result in it.

- So to use DP in any problem:- it should have below properties.
1) Overlapping Subproblem
2) Optimal substructure :- Solving a problem by breaking into a multiple sub problem. means problem can be broken
down into multiple sub problem. it should not be like ip is given and you are calculating result directly on basis of
it.


- There are 2 types of DP.
1) Memoization :- Recursion + Pass DP arr to Recursion
2) Tabulation :- Iterative (Just create DP array) solve it without using recursion.

- Memoization also called the Top-Down bec the way we calculate the result is from top to bottom like for example for
fibonacci, we are calling fib(5) --> fib(4) and fib(3) --> then fib(2) and fib(1) and so on. So if you see carefully
flow of function calls is from TOP -- BOTTOM

- Tabulative is also called Bottom-Up approach. Bec the way we calculate the result is from bottom to up like for exa:-
for fib(5)--> 1st we store value of 0 and 1 in DP array then start iterating on it from 2 to 6 and calculating result
based on previously stored results.

# Just discussing few terms as it is used by so many other developers for DP problems.
- DP table :- it is nothing but simply DP array.
- DP State :- DP state is nothing but the place at which you got final answer. i.e. here in fibonacci problem you have
returned the DP[n] ie. DP[5]. So DP[n] is DP state. bec sometimes you will see in some other problems ki you are
getting final answer on DP[0] or DP[N-1] something, So the place at which I am getting final answer to return the result
is called DP State. means wese to every cell is called DP State.
So just redefining, state is every cell of DP array is DP state. i.e here DP[i] is a state. But in case of 2D array
problems DP[i] is not state of DP ryt, DP[i][j] is the state of DP. bec it is the one which is representing a single
cell in DP.

- DP Expression :- is simply nothing but whatever expr we are using in iterative approach to compute the current ith
value from previously calculated values. for examp:- for fibbo problem DP expr :- DP[i] = DP[i-1] + DP[i-2].


Note :- After above discussion, just recalling you, like previously also we have used the DP just unknowingly as just
the thing was we were not aware like it is called DP since we are calculating unique result once only and stored
it somewhere to use in future. So previously we have used Prefix Array (PF), that is also DP concept ryt.
 */

public class DPIntro {
}
