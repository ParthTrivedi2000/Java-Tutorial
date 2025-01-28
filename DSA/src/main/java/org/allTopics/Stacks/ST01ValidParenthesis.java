package org.allTopics.Stacks;

import java.util.Stack;

// Problem Link:-  https://leetcode.com/problems/valid-parentheses/description/

/*
Problem Description:-
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
Example 3:
Input: s = "(]"
Output: false
Example 4:
Input: s = "([])"
Output: true

Constraints:
1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.
 */

public class ST01ValidParenthesis {
    // Approach:- see here, I want something like through which I can take decision based on latest element. but
    // simultaneously after checking latest elem, I also want to check for 2nd latest then 3rd latest etc etc...So i
    // have to think of some DS which can fulfill the above requirement. So stack and array either of them can be used
    // ryt. but array might be having more TC then Stack in case of insertion/deletion.
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length()%2!=0) return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='[') st.push(s.charAt(i));
                // while popping, you also need to check weather pair is matching or not
            else{
                if(st.isEmpty() || (!st.isEmpty() && valid(s.charAt(i),st.pop())==false)) return false;
            }
        }
        return st.isEmpty();
    }

    boolean valid(char pushed,char popped){
        if((pushed==')' && popped=='(') || (pushed==']' && popped=='[') || (pushed=='}' && popped=='{')) return true;
        return false;
    }
}
