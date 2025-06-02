package org.allTopics.Greedy;

// Problem Link :-https://leetcode.com/problems/jump-game/description/

// Problem Description:-
/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible
to reach the last index.

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5

 */

public class G04JumpGame_1 {
    public static void main(String[] args) {}

    public boolean canJump(int[] nums) {


        // // Approach - 1:- Recursive Approach:-  TC:- O(k^N) where k is max elem of arr, SC:- O(N) for rec space
        // return rec(nums,0);


        // // Approach - 2:- Memoized :- TC:- O(N*N), SC:- O(N) for dp + O(N) for rec space
        // Boolean[] dp = new Boolean[nums.length];
        // return memo(nums,0,dp);

        // Approach - 3:- Tabulation :- TC:- O(N^2), SC:- O(N)
        // dp[i] = can I reach the ith place?
        // so here since we have been told that person is starting from 0, i.e. we can say that
        // I can reach 0th place --> i.e. dp[0]=true;

        /*
        Boolean[] dp = new Boolean[nums.length];
        dp[0] = true;
        for(int i=1;i<nums.length;i++){
            // now here we can think in reverse way. means see I am standing at ith place & I
            // want to fill the ith place. So I can check for all it's prev elems like weather
            // any elem muje i pe ya to i se jyada koi index pe pahucha skta h ya nh?
            // if yes, then also we have to check for 2nd consition as well, means weather
            // dp[j] ==true h i nh? i.e. wo hi agr false h i.e. we can't even reach on that
            // idx bec dp[j]=false i.e. jth idx pe pahuch hi nh skte h.
            dp[i]=false;
            for(int j=i-1;j>=0;j--){
                if(j+nums[j]>=i && dp[j]==true){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[nums.length-1];

         */


        // Intuition & Approach - 4:- Optimised Approach --> using greedy.
    /*
    So array is given. And nums[i] represent the max jumps we can take from that ith position. we have to return the true
    if we are able to reach the end.
    - So simply if you can observe, if I will be somehow falling on the ith place where nums[i]=0, from there I can't take
    any jump ryt since nums[i]=0. So suppose there is no elem 0 in the array, then for sure we can reach the end ryt that
    much we can observe.
    - Another thing is, suppose somehow we can cross the place where elem=0, then also we can reach the end ryt.
    - So simply my logic would be with any of the combination will it be possible to reach the any of the next elem which are
    after elem=0, then simply we can break there and no need to check further & we can return true from there.
    - for example:- [1,2,4,1,1,0,2,5] --> with any combination can I reach to elem=2 or 5 which is present after 0
    if yes then we can return the true. If we can't reach with any combination then we can return 0.
    - for example:- [1,2,3,1,1,0,2,5] --> false (pls dry run in mind)

    (please tell all these edge cases to the interviewer like if 0 is not present then we can straight away return true,
    means in that case we always can reach to the end.

    Approach:-
    - So we can simply maintain the maxIndex variable. And we can check till what index you can jump max.

    Step 1:Initialise a variable maxIndex to keep track of the farthest index we can reach from the start
    Step 2: Iterate through each index of the array and at each interaction check if the current index is greater than
    the maximum index we can reach so far.
    Step 3: If the current index is greater than maxIndex, it means the current index is not reachable hence we
    return false.
    Step 4: But if current index is reachable we update the maxIndex to be the maximum of the current value of maxIndex
    and maximum index we can reach from current index ie. i + nums[i].
    Step 5: If we exit the loop without returning false, it means we have reached the last index, therefore we can
    return a true.

    for example :- [1,2,4,1,1,0,2,5] -->
    dry run:-
    maxIdx=0;
    elem=1 --> maxIdx=max(maxIdx,current_i+elem)=>1;
    elem=2 --> maxIdx=max(maxIdx,current_i+elem) => 3;
    elem=4 --> maxIdx=max(maxIdx,current_i+elem) => 6;
    elem=1 --> maxIdx=max(maxIdx,current_i+elem) => 6;
    elem=1 --> maxIdx=max(maxIdx,current_i+elem) => 6;
    elem=0 --> maxIdx=max(maxIdx,current_i+elem) => 6;
    elem=2 --> maxIdx=max(maxIdx,current_i+elem) => 8;
    once we reach the endIdx+1 => we can return true from here.

    But let's dry run where we can't reach the end.
    for example:- [1,2,3,1,1,0,2,5]
    dry run:-
    maxIdx=0;
    elem=1 --> maxIdx=max(maxIdx,current_i+elem)=>1;
    elem=2 --> maxIdx=max(maxIdx,current_i+elem) => 3;
    elem=3 --> maxIdx=max(maxIdx,current_i+elem) => 5;
    elem=1 --> maxIdx+=max(maxIdx,current_i+elem) => 5;
    elem=1 --> maxIdx+=max(maxIdx,current_i+elem) => 5;
    // here now we move to next elem=0 i.e. i=6 => so, i>maxIdx i.e. we can never reach the end.

     */

        // Approach - 4:-  TC:- O(N), SC:- O(1)
        int maxIdx = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIdx) return false;
            maxIdx = Math.max(maxIdx,i+nums[i]);
            // if at any point maxIdx already reached at the end then from then and there we can return true
            if(maxIdx>=nums.length) return true;
        }
        return true;
    }

    private boolean rec(int[] nums, int idx){
        // by me
        if(idx==nums.length-1) return true;
        if(idx>nums.length) return false;
        // rec call
        boolean ans = false;
        for(int i=1;i<=nums[idx];i++){
            ans = ans|| rec(nums,idx+i);
        }
        return ans;

        // Or :- more optimised rec function
        /*
        if(idx==nums.length-1) return true;
        if(idx>nums.length) return false;
        // rec call
        for(int i=1;i<=nums[idx];i++){
            if(rec(nums,idx+i)==true) return true;
        }
        return false;
         */
    }

    private boolean memo(int[] nums, int idx, Boolean[] dp){
        if(idx==nums.length-1) return true;
        if(idx>nums.length) return false;
        if(dp[idx]!=null) return dp[idx];
        boolean ans=false;
        for(int i=1;i<=nums[idx];i++){
            ans=ans|| memo(nums,idx+i,dp);
        }
        dp[idx]=ans;
        return ans;

        // Or:- More optimised memo function call
        /*
        if(idx==nums.length-1) return true;
        if(idx>nums.length) return false;
        if(dp[idx]!=null) return dp[idx];
        for(int i=1;i<=nums[idx];i++){
            if(memo(nums,idx+i,dp)){
                dp[idx]=true;
                return true;
            }
        }
        dp[idx]=false;
        return false;

         */
    }

}
