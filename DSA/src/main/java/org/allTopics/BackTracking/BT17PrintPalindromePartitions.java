package org.allTopics.BackTracking;

// Problem Link ;- https://leetcode.com/problems/palindrome-partitioning/description/

// Problem Description :-
/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome
partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.

 */

import java.util.ArrayList;
import java.util.List;


public class BT17PrintPalindromePartitions {
    public List<List<String>> partition(String s) {
        List<String> seq = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        recBacktrack(s,0,seq,ans);
        return ans;
    }

    // TC:- O(N*2^N-1), SC:- O(N)
    private void recBacktrack(String s, int idx, List<String> seq, List<List<String>> res){
        // Base Condition
        if(idx==s.length()){
            res.add(new ArrayList<>(seq));
            return;
        }

        StringBuilder palindromicString = new StringBuilder();
        for(int i=idx;i<s.length();i++){
            palindromicString.append(s.charAt(i));
            if(isPalindrome(palindromicString)){
                seq.add(palindromicString.toString());
                recBacktrack(s,i+1,seq,res);
                seq.remove(seq.size()-1);
            }
        }
    }

    private boolean isPalindrome(StringBuilder str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
