package org.allTopics.Stacks;

// Problem link:- https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

/* Remove All Adjacent Duplicates In String
Problem Description:-
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two
adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible
move. The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
 */

import java.util.Stack;

public class DoubleCharacterTrouble {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(!st.isEmpty() && ch==st.peek()) st.pop();
            else st.push(ch);
        }

        StringBuilder ans = new StringBuilder();
        for(char el:st){
            ans = ans.append(el);
        }
        return ans.toString();
    }
}
