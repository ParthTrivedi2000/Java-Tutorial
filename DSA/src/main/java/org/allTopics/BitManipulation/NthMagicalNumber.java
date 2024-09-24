package org.allTopics.BitManipulation;

// Problem Link :- https://www.geeksforgeeks.org/problems/magic-number4431/1

/*
Problem Description :-
A magic number is defined as a number that can be expressed as a power of 5 or sum of unique powers of 5. First few
magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), …
Given the value of n, find the n'th Magic number modulo 10^9+7.

Example 1:
Input: n = 1
Output: 5
Explanation: 1'st Magic number is 5.
Example 2:
Input: n = 2
Output: 25
Explanation: 2'nd Magic number is 25.

Expected Time Complexity: O(log n)
Expected Auxiliary Space: O(1)
 */

public class NthMagicalNumber {

    /*
    Approach - 1:- Bruteforce Solution:-
    Generate magic numbers one by one until we reach the Ath number.
    Time Complexity: O(A * log A)
    Space Complexity: O(1)
    Write code below in your free time

    Approach - 2:- Dynamic Programming Approach:
    Create an array to store magic numbers.
    Generate magic numbers using previously calculated ones.
    Time Complexity: O(A)
    Space Complexity: O(A)
    Write code below in your free time

    Approach -3 Optimised Approach:- Bit manipulation:- TC:- O(1) SC:- O(1)
    Let's approach this step by step.
    First, have you noticed any pattern in the magic numbers? Think about how we can represent these numbers
    using powers of 5.
    Here's a hint: Consider the binary representation of the index (A). How might this relate to the powers of 5
    we need to sum?
    Try to work out the first few magic numbers and see if you can spot a pattern. What happens when you write out the
    binary of their indices?
    response: Let's start by thinking about the pattern. Can you tell me what the first few magic numbers are, and
    how they relate to powers of 5?
    Now, let's think about how these relate to powers of 5.
    5 = 5^1 25 = 5^2 30 = 5^1 + 5^2 125 = 5^3 130 = 5^1 + 5^3
    Do you notice anything about how these numbers are formed? They're sums of distinct powers of 5.
    Here's a hint: Consider the binary representation of the index. For example:
    1 (binary 001) -> 5^1 = 5 2 (binary 010) -> 5^2 = 25 3 (binary 011) -> 5^2 + 5^1 = 30
    Can you see how the binary digits relate to which powers of 5 we use?
    response: Based on this pattern, how do you think we could use the binary representation of A to calculate
    the Ath magic number?

    Think of the binary representation of A as a set of instructions. Each '1' in the binary representation tells us to
    include a specific power of 5 in our sum.
    For example:
    If A = 3, its binary is 011
    Reading from right to left:
    1 in the first position means include 5^1
    1 in the second position means include 5^2
    0 in the third position means don't include 5^3
    So the 3rd magic number is 5^1 + 5^2 = 5 + 25 = 30
    Here's a hint: Instead of calculating powers of 5 directly, what if we start with 1 and keep multiplying by 5 for
    each position in the binary representation of A?
    response: Can you try to write a loop that goes through the binary representation of A and constructs the magic
    number based on this idea?
     */

    static long nthMagicNo(int n){
        //complete the function here
        long res = 0;
        long pow = 5;
        // binary representation of A
        for(int i=0;i<=31;i++){
            if((n&(1<<i))!=0){
                // Adding multiple of 5 each time when found the ith bit as 1 of number A.
                res+=pow;
            }
            pow=pow*5;
        }
        return (long)res%1000000007;
    }
}
