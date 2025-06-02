package org.allTopics.DynamicProgramming;

// Problem Link:- https://leetcode.com/problems/house-robber-ii/description/

// Problem Description :-
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two
adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:
Input: nums = [1,2,3]
Output: 3

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */

import java.util.Arrays;

public class DP07HouseRobberII {
    public int rob(int[] nums) {


        // Approaches :- This is actually DP problem since it is subsequence.

        // case - 1:- taking 0th home, so can't take n-1th home hence range would be
        // 0 to n-2. :- helper(nums,0,nums.length-2);

        // case - 2:- Not taking 0th home, so we can take n-1th home hence range would
        // be 1 to n-2. :- helper(nums,1,nums.length-1);

        // Approach - 1:- Recursive:- (TC:- (2^n), SC:- O(n))
        /*
        Since it was given subsequence, standard way is to use the pick/not pick logic.

        helper(nums,0,nums.length-2);
        helper(nums,1,nums.length-1);


        return Math.max(helper(nums,0, nums.length-2),helper(nums,1,nums.length-1));
    }

    int helper(int[] arr, int startIndex, int endIndex){
        if(endIndex==startIndex) return arr[startIndex]; // base condition
        if(endIndex<startIndex) return 0; // invalid index edgecase handling
        int pick = arr[endIndex] + helper(arr,startIndex,endIndex-2);
        int notPick = helper(arr,startIndex,endIndex-1);
        int ans = Math.max(pick,notPick);
        return ans;
    }

         */


        // Approach - 2:- Memoization :- (TC:- O(N), SC:- O(N)+O(N)=O(2N))

        /*
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        // case - 1:- Taking 0th house
        int taking0thHouse = memoized(nums,dp,0,nums.length-2);
        // case - 2:- Not taking 0th House
        Arrays.fill(dp, -1);
        int notTaking0thHouse = memoized(nums,dp,1,nums.length-1);
        return Math.max(notTaking0thHouse,taking0thHouse);

        // Note:- Here please note that, we have to fill the DP arr with -1 at starting (not with 0 or Integer.MIN_VALUE)
        // else few Test Cases are failing.
    }

    int memoized(int[] arr,int[] dp, int startIndex, int endIndex){
        if(startIndex==0){
            if(endIndex==startIndex) {
                dp[startIndex] = arr[startIndex];
                return arr[startIndex];
            }
            if(endIndex<startIndex) return 0;
            if(dp[endIndex]!=-1) return dp[endIndex];
            int pick = arr[endIndex] + memoized(arr,dp,startIndex,endIndex-2);
            int notPick = memoized(arr,dp,startIndex,endIndex-1);
            dp[endIndex] = Math.max(pick,notPick);
            return dp[endIndex];
        }
        else if(startIndex==1){
            if(endIndex==startIndex) {
                dp[0]=0;
                dp[startIndex] = arr[startIndex];
                return arr[startIndex];
            }
            if(endIndex<startIndex) return 0;
            if(dp[endIndex]!=-1) return dp[endIndex];
            int pick = arr[endIndex] + memoized(arr,dp,startIndex,endIndex-2);
            int notPick = memoized(arr,dp,startIndex,endIndex-1);
            dp[endIndex] = Math.max(pick,notPick);
            return dp[endIndex];
        }
        return -1;
    }

     */

        // Approach - 3:- Tabulative :- (TC:-O(N), SC:-O(N))
        if(nums.length==1) return nums[0];

        // case - 1:- taking 0th house
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<dp.length-1;i++) dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        int case1 =  dp[nums.length-2];

        Arrays.fill(dp,0);
        dp[1] = nums[1];
        for(int i=2;i<dp.length;i++) dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        int case2 =  dp[nums.length-1];

        return Math.max(case1,case2);
    }

    // Note:- Else what we can do is, here actually we are always start picking values from end
    // as we have seen from above all the DP problems till now.
    // So if you want to follow that, then please try considering that start by considering last n-1th house
    // and not considering last n-1th house. (instead of considering 0th and not considering 0th house as shown
    // in above approach). Means in that cases, I think we just need to restrict our call/loop from n-1 to 1st
    // index, and n-2 to 0th index correspondingly. Please try it once.
}
