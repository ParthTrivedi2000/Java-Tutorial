package org.allTopics.DynamicProgramming;

// Problem Link :- https://leetcode.com/problems/target-sum/description/

/*
Problem Description :-
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and
then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the
expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:
Input: nums = [1], target = 1
Output: 1

Constraints:
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000

 */

// Intution :-
/*
- So here what we need to do is, we have to use +,-  operators to get the target sum by using given array elems.
Now means see, suppose I am having arr=[1,1,2,3], target=1. Now I can use +,- signs to get the target. Now see i can
put +1+1+2-3 =1
then, +1-1-2+3 = 1
then -1+1-2+2= 1
I think these are the only possible combinations.
So if you observe carefully, we can group elems with + signs together & elems with - signs together. it means suppose
for above 1st combination:- 1,1,2 and 3, same for 2nd combination:- 1,3 & 1,2.
- So with above observation, try to think how with which question it is related to the problems we did so far.
- Exactly, it looks similar (not even similar, I can say same as the question of partition with given difference ryt?
- means we just have do partition of the elems in such a manner that differece = target, then I can put + sign to
the 1st partition & - sign to the another partition.
- So solution is exact same code of above partition array to get the given difference problem.
 */

public class DP15TargetSum {
}
