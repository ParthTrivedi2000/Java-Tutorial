package org.allTopics.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Q - 6) Longest Substring with K unique characters.
// Problem Link :- https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

// Problem Statement :-
/*
Given a string you need to print the size of the longest possible substring that
has exactly K unique characters. If there is no possible substring then print -1.

Example :-
Input:
S = "aabacbebebe", K = 3
Output:
7
Explanation:
"cbebebe" is the longest substring with 3 distinct characters.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ |S| ≤ 10^5
1 ≤ K ≤ 26
All characters are lowercase latin characters.
 */

public class SW06LongestSubstringWithKUniqueCharacters {
    public int longestkSubstr(String s, int k) {
        // code here
        // Adity Verma's Template :-
        /*
            // We will use Map ds instead of Set to store these unique chars. bec in map we can keep track
            // of count as value corresponding key as character. and we can use it further.
            int i=0;
            int j=0;
            int maxLen = -1;
            char ch = '0';
            // Set<char> hash_set = new HashSet<>();
            HashMap<Character,Integer> mp = new HashMap<>();
            while(j<s.length()){
                ch = s.charAt(j);
                if(!mp.containsKey(ch)) {//add key as char nd value as 0
                    mp.put(ch,1);
                }
                else{//update the value corresponding key by 1
                    mp.put(ch,mp.get(ch)+1);
                }
                if(mp.size()<k){
                    j++;
                }
                else if(mp.size()==k){
                    maxLen = Math.max(maxLen,j-i+1);
                    j++;
                }
                else if(mp.size()>k){
                    while(mp.size()>k){
                        mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                        if(mp.get(s.charAt(i))==0){
                            mp.remove(s.charAt(i));
                        }
                        i++;
                    }
                     j++;
                }
            }
            return maxLen;
        */

        // Striver's template:-
        int i=0;
        int j=0;
        int maxLen = -1;
        char ch = '0';
        Map<Character,Integer> mp = new HashMap<>();
        while(j<s.length()){
            ch = s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
            if(mp.size()>k){
                mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                if(mp.get(s.charAt(i))==0){
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            else if(mp.size()==k){
                // if (mp.size()==K)
                maxLen = Math.max(maxLen,j-i+1);
            }
            j++;
        }
        return maxLen;
    }
}
