package org.allTopics.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Q - 7) Longest Substring Without Repeating Characters :-

// Problem Link :- https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Problem Statement:-
/*
Given a string s, find the length of the longest substring without repeating characters.
Example:-
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 10^4
s consists of English letters, digits, symbols and spaces.
 */


public class SW07LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Brute force Approach :-
        /*
        // Generate all the substring and check for the given condition.
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
        //  we can use set as well. purpose of this DS is to check weather the current char is previously visited
            or not.
            Set < Character > se = new HashSet < > ();
            int[] visited = new int[256];
            for(int j=i;j<s.length();j++){
                if(visited[s.charAt(j)]==1) break; // if any char is encountered 2nd time, then we just need to
                // break that substring. And we can store the length till that particular char.
                len = j-i+1;
                maxLen = Math.max(len,maxLen);
                visited[s.charAt(j)] = 1; // marking this char at visited for the case if you visit it 1st time
            }
        }
        return maxLen;
        // TC of above approach:- O(N^2),  SC:-O(256)

         */

        // working & tested code per Aditya Verma's template
        int i=0;
        int j=0;
        int ans = 0;
        Map<Character,Integer> mp = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(!mp.containsKey(ch)) mp.put(ch,1);
            else mp.put(ch,mp.get(ch)+1);

            // While condition is true
            if(mp.size()==j-i+1){
                ans = Math.max(ans,j-i+1);
                j++;
            }
            else if(mp.size()<j-i+1){
                // remove impact of prev i
                while(mp.size()<j-i+1){
                    if(mp.containsKey(s.charAt(i))) mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                    if(mp.get(s.charAt(i))==0) mp.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return ans;

        // Striver's Solution.
        // Approach - 3:- using a hashArray(instead of Map) & Sliding window.
        /*
        // remember here we are not only maintaining true false in hash array instead here we are
        // storing index (or updated index if elem is repeated) to keep track further.
        int i=0;
        int j=0;
        int maxLen = 0;
        char ch = '0';

        int[] hash = new int[256];
        for(int p=0;p<hash.length;p++){
            hash[p] = -1;
        }
        // Starting sliding window algo
        while(j<s.length()){
            ch = s.charAt(j);
            if(hash[ch]!=-1 && hash[ch]>=i) {
                i=hash[ch]+1;
            }
            maxLen = Math.max(maxLen,j-i+1);
            hash[ch] = j;
            j++;
        }
        return maxLen;

// Note:- Highly recommend to go through this article once. In this striver has used Map to store the char and updated
//        indexes instead of frequency. So we can directly update it with new index in case we found 2nd time.
//        And whenever get time, just implement code here all the 3 approaches with explanation/your understanding.
//        https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/

         */
    }
}
