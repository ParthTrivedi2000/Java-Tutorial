package org.allTopics.Strings;

// Problem Link :- https://www.geeksforgeeks.org/problems/encode-and-decode-strings/1

// Problem Description :-
/*
Given an array of strings s[], you are required to create an algorithm in the encode() function that can convert
the given strings into a single encoded string, which can be transmitted over the network and then decoded back
into the original array of strings. The decoding will happen in the decode() function.

You need to implement two functions:
1. encode(): This takes an array of strings s[] and encodes it into a single string.
2. decode(): This takes the encoded string as input and returns an array of strings containing the original array
as given in the encode method.

Note: You are not allowed to use any inbuilt serialize method.

Examples:

Input: s = ["Hello","World"]
Output: ["Hello","World"]
Explanation: The encode() function will have the str as input, it will be encoded by one machine. Then another
machine will receive the encoded string as the input parameter and then will decode it to its original form.
Input: s = ["abc","!@"]
Output: ["abc","!@"]
Explanation: The encode() function will have the str as input, here there are two strings, one is "abc" and the
other one has some special characters. It will be encoded by one machine. Then another machine will receive the
encoded string as the input parameter and then will decode it to its original form.
Constraints:
1<=s.size()<=100
1<=s[i].size()<=100
s[i] contains any possible characters out of the 256 ASCII characters.

Expected Complexities
Time Complexity: O(n)
Auxiliary Space: O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder sb = new StringBuilder();
        sb.append('*');
        for(String str:s){
            for(char ch:str.toCharArray()){
                sb.append(ch);
            }
            sb.append('*');
        }

        return sb.toString();
    }

    public String[] decode(String s) {
        // write your logic to decode the string

        List<String> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<s.length()){
            if(s.charAt(i)=='*'){
                j=i+1;
                StringBuilder sb = new StringBuilder();
                while(j<s.length() && s.charAt(j)!='*'){
                    if(s.charAt(j)=='*') break;
                    sb.append(s.charAt(j));
                    j++;
                }
                ans.add(sb.toString());
                i=j;
            }
            else i++;
        }

        String[] res = new String[ans.size()];
        for(int k=0;k<res.length;k++){
            res[k] = ans.get(k);
        }
        return res;
    }
}
