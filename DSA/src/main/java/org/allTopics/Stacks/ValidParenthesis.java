package org.allTopics.Stacks;

import java.util.Stack;

// Problem Link:-  forget to put it here. Just go to leetcode and put it here in your free time

public class ValidParenthesis {
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
