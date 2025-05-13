package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/generate-parentheses/description/

// Problem Description :-
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8

 */

import java.util.ArrayList;

public class BT03GenerateAllParenthesis {
    public static void main(String[] args) {}

    public static ArrayList<String> generateParenthesis(int n){

        /*
        Approach:-
         whenever open>0 I m always having choice of using "(" in ans while same is not the case with ")"
         since ")" is the option only when close>open
         */

        StringBuilder seq = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        recBacktrack(n,n,seq,res);
        return res;
    }

    public static void recBacktrack(int open, int close, StringBuilder seq, ArrayList<String> op){
        if(open==0 && close==0){
            op.add(seq.toString());
            return;
        }

        if(close>open){
            seq.append(")");
            recBacktrack(open,close-1,seq, op);
            seq.deleteCharAt(seq.length() - 1);
        }
        if(open>0){
            seq.append("(");
            recBacktrack(open-1,close,seq,op);
            seq.deleteCharAt(seq.length() - 1);
        }
    }
}
