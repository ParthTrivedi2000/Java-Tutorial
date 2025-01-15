package org.allTopics.Hashing;

// Problem Link :- https://leetcode.com/problems/longest-consecutive-sequence/description/

/*
Problem Description :-

 */

import java.util.HashSet;
import java.util.Set;

public class H09LongestConsecutiveSequence {

    public int longestConsecutive(int[] arr) {
        // My Old Approach:- TC:- O(N) + O(NlogN), SC:- O(N)+O(N)

        /*
         if(A.length==1) return 1;

         Set<Integer> st = new HashSet<>();
         for(int elem:A) st.add(elem);

         int[] temp=new int[st.size()];

         // for(int i=0;i<st.size();i++) temp[i] = st.get(i);
         int idx=0;
         for(int elem:st){
             temp[idx] = elem;

             // System.out.println(temp[idx]);
             idx++;
         }

         Arrays.sort(temp);

         int cnt=0;
         int ans = 0;
         for(int i=1;i<temp.length;i++){
             if(temp[i]-temp[i-1]==1){
                 cnt++;
                 ans = Math.max(ans,cnt);
             }
             else cnt=0;
         }
         return ans+1;

         */


        // Optimised Approach:- TC:- O(N)+O(N), SC:- O(N)
        /*
        Approach:-
         we can dump all the elems in the set.
         then in the set for each element we can check if elem-1 exists in the set
         or not. if not in the set, then we can say that particular element as
         start of the sequence. as soon as we get start point then now I want to
         find next how many elems present in the hashset hence we can return that ans.
         so just use the counter and check weather next of start exist in the array
         or not.

         */

        if(arr.length<2) return arr.length;
        Set<Integer> st =  new HashSet<>();
        for(int elem:arr) st.add(elem);

        int ans=Integer.MIN_VALUE;
        for(int elem:st){
            if(!st.contains(elem-1)){// if not then only we can say ki yes this is the start point
                int start = elem;
                int cnt=0;
                // Now just chekcing, next how many elems are present in the set.
                while(st.contains(start)){
                    cnt++;
                    start++;
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}
