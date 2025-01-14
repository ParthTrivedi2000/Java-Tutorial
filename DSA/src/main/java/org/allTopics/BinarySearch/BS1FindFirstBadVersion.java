package org.allTopics.BinarySearch;

// problem Statement:- https://leetcode.com/problems/first-bad-version/description/

// Problem Description :-
/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
of your product fails the quality check. Since each version is developed based on the previous version, all the
versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find
the first bad version. You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:
Input: n = 1, bad = 1
Output: 1

Constraints:
1 <= bad <= n <= 2^31 - 1

 */

/*
So pls keep below few things in mind.

- There can be either Minimisation or Maximisation type of problem based on the Monitonicity / monotonic function that
you have to design. So if it's Minimisation type:- then pattern of your condition's return value can be like
[FFFFTTT] --> here you need to find the 1st True/Valid value. And we always return hi in case of Minimisation problem.
If it' s maximisation type problem, it can be [TTTTFFF] --> i.e. here you need to find the last True/Valid value.
And we always return lo in case of Maximisation problem.

And similarly initialisation also needs to be done by considering it based on Minimisation/Maximisation
- Initialisation :-
if it's Minimisation:-
    - then lo = 1st inValid value
           hi = Max valid value from start
    - for exa.:- if search space is:- [1 to n ] both inclusive, then initialisation should be:- lo = -1, hi = n
if it's Maximisation:-
    - then lo = 1st Valid Value
           hi = 1st Invalid value from end
    - for exa.:- if search space is:- [1 to n ] both inclusive, then initialisation should be:- lo = 1, hi = n+1

So idea above is, in case of Minimisation, lo always holds the Invalid value only, it should never be on valid answer
value. And hence only at last we will return hi as the answer in case of Minimisation.
And in case of Maximisation, lo always consists of Valid answer values and hi always consists of invalid answer values.
And hence only we will return lo in case of Maximisation.

- while condition would always be (lo+1<hi). Pls see below template.
// minimize x such that condition(x) is true
function binarySearch(arr) {
  // decide what is the search space
  // hi should be able to take all possible values in the search space
  // lo points to an invalid value (the negative case of the if condition)
  let lo = -1, hi = arr.length;
  while (lo + 1 < hi) {
    let mid = lo + Math.floor((hi - lo) / 2);
    if (condition(arr, mid)) {
      hi = mid
    } else {
      lo = mid;
    }
  }

  // in minimization template, hi contains the return index
  return hi;
}

// maximize x such that condition(x) is true
function binarySearch(arr) {
  // decide what is the search space
  // lo should be able to take all possible values in that search space
  // hi points to an invalid value (the negative case of the if condition)
  let lo = -1, hi = arr.length;
  while (lo + 1 < hi) {
    let mid = lo + Math.floor((hi - lo) / 2);
    if (condition(arr, mid)) {
      lo = mid;
    } else {
      hi = mid;
    }
  }

  // in maximization template, lo contains the return index
  return lo;
}

function condition(arr, idx) {
  // some condition on arr[idx]
  // return true or false
  return true;
}

 */

public class BS1FindFirstBadVersion {
    public int firstBadVersion(int n) {
        int lo = 0; //1st invalid value
        int hi = n; // max vaid value
        while(lo+1<hi){
            int mid = lo + (hi-lo)/2;
//            if(isBadVersion(mid)){ // Commenting out as it is showing error in IDE so.
            boolean cond=true;
              if(cond==true){
                hi=mid;
            }
            else lo=mid;
        }
        return hi;
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
