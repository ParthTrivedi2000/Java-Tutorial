package org.allTopics.Greedy;

import java.util.Arrays;

public class G05JumpGame_2 {
    public int jump(int[] nums) {
        // // Approach - 1: Recursive :- TC:- O(N^N), SC:- O(N) for rec space
        // return rec(nums, 0);

         // Approach - 2: Memoized :- TC:- O(N^2), SC:- O(N) for rec space + O(N) for dp
        /*
         int[] dp = new int[nums.length];
         Arrays.fill(dp,-1);
         return memo(nums, 0, dp);

         */

         // // Approach - 3:- Tabulation :- TC:- O(N^2), SC:- O(N) for dp
         // dp[i] = minimum number of jumps needed to reach index i
        /*
         int n = nums.length;
         int[] dp = new int[n];
         Arrays.fill(dp, Integer.MAX_VALUE);
         dp[0] = 0; // 0 jumps to reach index 0

         for (int i = 0; i < n; i++) {
             int maxJump = nums[i];
             for (int j = 1; j <= maxJump && i + j < n; j++) {
                 if (dp[i] != Integer.MAX_VALUE) {
                     dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                 }
             }
         }
         return dp[n - 1];

         */


        // Approach - 4:- Optimised :- Use Greedy :- TC:- O(N), SC:- O(1)

        int jump=0;
        int left=0;
        int right=0;

        while(right<nums.length-1){
            int farthest = 0;
            for(int i=left;i<=right;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            left = right+1;
            right = farthest;
            jump++;
        }
        return jump;

    }

    private int rec(int[] nums, int idx){
        if(idx==nums.length-1) return 0;
        int cnt=Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx] && idx+i<nums.length;i++){
            int sa = rec(nums,idx+i);
            if(sa!=Integer.MAX_VALUE){ // else MAX_VALUE+1 is giving overflowed value in few TS
                cnt=Math.min(cnt,sa+1);
            }
        }
        return cnt;
    }

    private int memo(int[] nums, int idx, int[] dp){
        if(idx==nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int cnt=Integer.MAX_VALUE;
        for(int i=1;i<=nums[idx] && idx+i<nums.length;i++){
            int sa = memo(nums,idx+i,dp);
            if(sa!=Integer.MAX_VALUE){ // else MAX_VALUE+1 is giving overflowed value in few TS
                cnt=Math.min(cnt,sa+1);
            }
        }
        dp[idx] = cnt;
        return cnt;
    }
}
