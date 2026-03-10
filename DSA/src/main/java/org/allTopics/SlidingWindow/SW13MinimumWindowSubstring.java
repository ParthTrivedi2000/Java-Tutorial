package org.allTopics.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Q -8) Minimum Window Substring

// Problem Link:- https://leetcode.com/problems/minimum-window-substring/description/
// Problem Description:-
/*
Given two strings s and t of lengths m and n respectively, return the minimum window
substring of s such that every character in t (including duplicates) is included in the window. If there
is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:
m == s.length
n == t.length
1 <= m, n <= 10^5
s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */


public class SW13MinimumWindowSubstring {
    // As per Aditya Verma's Sliding Window Approach:-
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!mp.containsKey(t.charAt(i))) mp.put(t.charAt(i),1);
            else mp.put(t.charAt(i),mp.get(t.charAt(i))+1);
        }
        int count=mp.size();
        int i=0;
        int j=0;
        int ans=Integer.MAX_VALUE;
        int temp=0;
        int startIndex = -1;
        int endIndex=-1;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch, mp.getOrDefault(ch,0)-1);
                if(mp.get(ch)==0) count--;
            }
            if(count>0) j++;
            else if(count==0){
                temp=ans;
                ans=Math.min(ans,j-i+1);
                if(temp!=ans)
                    startIndex=i;
                while(count==0){
                    // char c2=s.charAt(i);
                    if(mp.containsKey(s.charAt(i))){
                        mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
                        if(mp.get(s.charAt(i))==1) count++;
                    }
                    // Shrinking Window
                    i++;
                    if(count==0){
                        ans=Math.min(ans,j-i+1);
                        if(temp!=ans)
                            startIndex=i;
                    }
                }
                j++;
            }
        }
        if(ans==Integer.MAX_VALUE) return("");
        return s.substring(startIndex,startIndex+ans);
    }
}
