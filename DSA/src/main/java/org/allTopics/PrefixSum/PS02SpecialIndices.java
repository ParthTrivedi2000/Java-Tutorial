package org.allTopics.PrefixSum;

// problem Link :- https://leetcode.com/problems/ways-to-make-a-fair-array/description/

/*
Problem Description :-
You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that
the index of the elements may change after the removal.

For example, if nums = [6,1,7,4,1]:

Choosing to remove index 1 results in nums = [6,7,4,1].
Choosing to remove index 2 results in nums = [6,1,4,1].
Choosing to remove index 4 results in nums = [6,1,7,4].
An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.

Return the number of indices that you could choose such that after the removal, nums is fair.

Example 1:
Input: nums = [2,1,6,4]
Output: 1
Explanation:
Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
There is 1 index that you can remove to make nums fair.
Example 2:
Input: nums = [1,1,1]
Output: 3
Explanation: You can remove any index and the remaining array is fair.
Example 3:
Input: nums = [1,2,3]
Output: 0
Explanation: You cannot make a fair array after removing any index.

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
 */

public class PS02SpecialIndices {
    public int waysToMakeFair(int[] nums) {

/*
BruteForce Approach :- TC:- O(N^2), SC:- O(1);
run a loop i from 0 to n.
For each index i, take sum of 0-->(i-1)th elem. if i%2==0 then add elem to evenSum else add in oddSum.
then again we have to run a loop from (i+1)th elem to n as it index already removed ryt so. Now in this 2nd case
we have to add the even indexed elem to the oddSum bec we are considering here that now i is removed(actually we
haven't removed but we haven't consider i in sum calculation if you notice carefully). i.e. we are considering the
indexes after ith index shift one place back hence for the indexes after i, we have to add the even indexed sum to
odd sum and odd indexed sum to even sum.
now after completion of whole summation for each i ignorance loop, just check weather evensum==oddsum or not. if yes
increase the cnt.
return the cnt.

        // // Bruteforce :-
        // int cnt=0;
        // for(int i=0;i<nums.length;i++){
        //     int evenSum = 0;
        //     int oddSum = 0;

        //     for(int j=0;j<i;j++){
        //         if(j%2==0) evenSum+=nums[j];
        //         else oddSum+=nums[j];
        //     }
        //     for(int j=i+1;j<nums.length;j++){
        //         if(j%2!=0) evenSum+=nums[j];
        //         else oddSum+=nums[j];
        //     }

        //     if(evenSum==oddSum) cnt++;
        // }
        // return cnt;

 */

        // Approach-2:- Using Prefix Sum :- TC:- O(N), SC:-O(2N)
        int[] even = new int[nums.length];
        int[] odd = new int[nums.length];

        even[0] = nums[0];
        odd[0]=0;
        for(int i=1;i<nums.length;i++){
            if(i%2==0){
                even[i]=even[i-1]+nums[i];
                odd[i]=odd[i-1];
            }
            else{
                odd[i]=odd[i-1]+nums[i];
                even[i]=even[i-1];
            }
        }

        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int preEven=0;
            int preOdd=0;
            int postEven=0;
            int postOdd=0;

            if(i==0){
                preEven=0;
                preOdd=0;
                postEven=odd[nums.length-1];
                postOdd=even[nums.length-1]-nums[0];
            }
            else{
                preEven=even[i-1];
                preOdd=odd[i-1];
                // Since post i removal, each odd indices and even indices are changing to even and odd respectively.
                // So adding them into reverse one's sum respectively.
                postEven=odd[nums.length-1]-odd[i];
                postOdd=even[nums.length-1]-even[i];
            }

            if(preEven+postEven==preOdd+postOdd) cnt++;
        }
        return cnt;
    }
}
