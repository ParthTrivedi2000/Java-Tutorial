package org.allTopics.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Q-3) Count Occurrences of Anagrams

// Problem Link :- https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

// Problem Statement:-
/*
Given a word pat and a text txt. Return the count of the occurrences of anagrams
of the word in the text.

Example:-
Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)

Constraints:
1 <= |pat| <= |txt| <= 10^5
Both strings contain lowercase English letters.
 */

public class SW07CountOccurrencesOfAnagrams {

    // Approach - 1:- BruteForce :-
    //  TC:- O((N-M)*MlogM), SC:- O(M)
    //  where N is the length of the text and M is the length of the pattern.
    //  The loop runs O(N) times, and inside, sorting takes O(MlogM).
    /*
    public static int countAnagrams(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int count = 0;

        if (m > n) return 0;

        char[] sortedP = pattern.toCharArray();
        Arrays.sort(sortedP);

        // Iterate through all substrings of size m
        for (int i = 0; i <= n - m; i++) {
            String substring = text.substring(i, i + m);
            char[] sortedSub = substring.toCharArray();
            Arrays.sort(sortedSub);

            // Check if sorted substring matches sorted pattern
            if (Arrays.equals(sortedSub, sortedP)) {
                count++;
            }
        }
        return count;
    }
     */


    int search(String pat, String txt) {
        // code here
        int windowSize = pat.length();
        // 1st let's create a Map to store the frequency of given string pat.
        // Then I have to check in txt string like weather this whole string is present
        // in String txt or not.
        // creating map to store the frequency of each character of given pattern
        // so that we can use it to check for anagrams.
        Map<Character,Integer> mp = new HashMap<Character,Integer>();
        char ch = '0';
        for(int k=0;k<windowSize;k++){
            ch = pat.charAt(k);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }
            else{
                mp.put(ch,1);
            }
        }

        // As we don't want to traverse on whole map everytime, we have initialised the count
        // Variable. and it will have all the distinct keys. as soon as value corresponding to
        // any key becomes 0 then we can reduce count, instead of actually removing element from map.
        // Since I don't want to traverse the Map each time, I am using count variable
        // to increase/decrease when any element of Map hits zero or again come back to>0 state
        int count = mp.size();

        // Hence benefit will be, whenever my j= windowsize condition match, at that time if this
        // count becomes 0 then I can say like all the letters are covered from given pat string.
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j<txt.length()){
            // Calculations:-

            // Removing chars from Map if i found in current window. and don't worry means
            // at last when we are about to slide window,just before that we perform
            // calculations for i. So at that time we perform reverse operations
            // means we will add the ith char in map and do corresponding change in count var.

            // So means instead of actually removing characters from Map, we are using count variable
            // to track like how many distinct chars are still pending to be matched from the given pat string.
            // means anyhow we will be decreasing chars from map but when freq of char become 0, if we
            // remove then next time we never came to know like which all chars were previously present in map.
            // that's why whenever if any char freq becomes 0, we just decrease the count variable. So original
            // map will always have the chars of pat string only with their frequencies.

            // Removing chars from Map if i found in current window
            if(mp.containsKey(txt.charAt(j))){
                mp.put(txt.charAt(j),mp.get(txt.charAt(j))-1);
                // And whenever next window comes, I don't want to traverse map again to save
                // the time complexity. hence using this count variable to track like any elem's
                // frequency becomes 0 or not in the Map.
                if(mp.get(txt.charAt(j))==0) count--;
            }

            if(j-i+1<windowSize){
                j++;
            }
            else if(j-i+1 == windowSize){
                if(count==0) ans++;

                // nullifying impact of current i on next ith iteration before sliding the window
                if(mp.containsKey(txt.charAt(i))){
                    if(mp.get(txt.charAt(i))==0) count++;
                    mp.put(txt.charAt(i),mp.get(txt.charAt(i))+1);
                }
                // Slide the Window
                i++;
                j++;
            }
        }
        return ans;
    }
}
