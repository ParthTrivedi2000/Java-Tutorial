package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

// Problem Description :-
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
letters.


Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

 */


// Intuition & Approach :-
/*
- See here we have been given the digits And we have to return back the combination of all the digits given. Now how we
apply recursion here.
- See means for example, 234 is given. so we can do like, if we are currently at 2, we can ask recursion to give ans with
remaining like 34, then if I am having ans of 34, I can append the letters mapped with 2. Same for suppose we are at 3,
then we expect recursion already gave me correct answer of remaining right of it's position, then I can just append my
answer to it. Simple.
- So we can start from right or left as well. But in our code we started considering from left.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BT09LetterPhone {
    public static void main(String[] args) {}


    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        Map<Integer,String> mp = new HashMap<>(){{put(2,"abc"); put(3,"def"); put(4,"ghi"); put(5,"jkl"); put(6,"mno"); put(7,"pqrs"); put(8,"tuv"); put(9,"wxyz");}};
        StringBuilder seq = new StringBuilder();
        List<String> res = new ArrayList<>();
        recBacktrack(digits,0,seq,res,mp);
        return res;
    }

    private void recBacktrack(String digits, int idx, StringBuilder seq, List<String> res, Map<Integer,String> mp){
        // Base Condition - 1:-
        if(idx==digits.length()){
            res.add(seq.toString());
            return;
        }

        for(char ch:mp.get(Integer.parseInt(String.valueOf(digits.charAt(idx)))).toCharArray()){
            seq.append(ch);
            recBacktrack(digits,idx+1,seq,res,mp);
            seq.deleteCharAt(seq.length()-1);
        }
    }

    // Conclusion :-
    /*
    Here, we need to generate all the combination of the number in the keypad
For each number we will have 3 letters so we are storing the values using a hashmap(unordered set)
And we are doing our work for the first number and asking recursion to do other task as we have 3 letters we are
traversing those letters and calling recursive functions and pushing the answers into temp and doing backtracking step
and finding ans and stopping the tree when it reaches bound.

Summary:
1. This question uses all the concepts of subsets and combinations we have studied so far.
2. In this problem, we need to generate all the words possible from the number of keypad given by the user as input
3. To solve this problem, we firstly need a unordered_map to map all the keypad characters like '2' , '3' , '4' , etc
with the letters they represent in the keypad phone. This can be done using unordered_map or vector using its indices
4. Now we need to create a function help which takes the given string s, ans vector to store all the answers, i to
iterate over given string and a temp string to store the current word we are making. Everything is passed by reference
to save space.
5. If i reaches to s.size(), it means we have traversed the entire string, so we put the temp word inside the ans vector
and return.
6. Else we would pick a string str = map[s[i]] . This will represent all the letters represented by i-th character of
string s.
7. We run a for loop for j = 0 till j < str.size() and we add str[j] character inside our temp string and ask Recursion
to solve for i+1th character.
8. After Recursion gives me the answer, we have to backtrack and pop the character we have included so that other
characters of string str can now take its place.
10. Lastly, we return ans vector from our given function.

Time complexity: O(3^N) [ As most of the letters has 3 choices so we can approximately say time complexity as 3^N]

Space Complexity: O(N) [ N is the size of the given string. This is because we can only process till i < s.size() ,
that's why Space Complexity is O(N)]

     */
}
