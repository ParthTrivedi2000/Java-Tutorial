package org.allTopics.Arrays.GenericGoodQuestions;

// Problem Link :- https://leetcode.com/problems/maximum-swap

/*
Problem Description :-
You are given an integer num. You can swap two digits at most once to get the maximum valued number.
Return the maximum valued number you can get.

Example 1:
Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.

Constraints:
0 <= num <= 10^8
 */

public class MaximumValuedNumber {
    public int maximumSwap(int num) {
        if(num==0 || num/10==0) return num;


        // // Approach - 1:- Bruteforce Approach :- O(noOfDigits * noOfDigits)
        // char[] chArr = Integer.toString(num).toCharArray();
        // for(int i=0;i<chArr.length;i++){
        //     // int maxi = Character.getNumericValue(chArr[i]);
        //     int maxIdx = i;
        //     for(int j=i+1;j<chArr.length;j++){
        //         if(chArr[j]>chArr[maxIdx]){
        //             // maxi = Character.getNumericValue(chArr[j]);
        //             maxIdx = j;
        //         }
        //     }

        //     if(maxIdx!=i){
        //         // swap(chArr,i,maxIdx);
        //         // swapping
        //         char temp = chArr[i];
        //         chArr[i] = chArr[maxIdx];
        //         chArr[maxIdx] = temp;
        //         return Integer.parseInt(new String(chArr));
        //     }
        // }
        // return num;



        // // Approach - 2:- Using suffix :- TC:-O(N), SC:- O(N)
        // // I can convert it into char array. Then just think why we are even applying
        // // inner for loop, bec I want to find the maximum from right side correct and
        // // that is taking extra O(N) TC. so that we can precalculate ryt?

        // // And one more thing is, I will store max right element's indices not elements
        // // so that I can use it directly.

        // char[] chArr = Integer.toString(num).toCharArray();

        // int[] maxRight = new int[chArr.length];
        // maxRight[maxRight.length-1] = maxRight.length-1;
        // for(int i=maxRight.length-2;i>=0;i--){
        //     if(chArr[i]>chArr[maxRight[i+1]]){
        //         maxRight[i] = i;
        //     }
        //     else maxRight[i] = maxRight[i+1];
        // }

        // // for 2736 => maxRight=[1,1,3,3]

        // for(int i=0;i<chArr.length;i++){
        //     if(chArr[i]<chArr[maxRight[i]]){
        //         //swapping
        //         char temp = chArr[i];
        //         chArr[i] = chArr[maxRight[i]];
        //         chArr[maxRight[i]] = temp;
        //         return Integer.parseInt(new String(chArr));
        //     }
        // }
        // return num;


        // Approach - 3:- Most Optimal:- TC:- O(N), SC:-O(1)
        // Now just think we are using extra space for this. but we can ommit this extra
        // space. Simply just think now, ki there are at max total 9 digits only correct
        // so what we can do is, instead of creating maxRight arr for all the digits (which
        // also might include duplicates as well), we can create constant maxRight arr
        // for these 9 digits only. And at each index we can store just it's corresponding
        // index of char array. So now to find max we have to traverse whole maxRight
        // array every time same as we have done above in 1st approach. But this won't
        // increase TC. since we are traversing on constant array hence constant time.
        // So inner loop still gives TC of O(1) only which is our main motive to go from
        // 1st approach to 2nd. And by this constant maxRight array we have done
        // optimisation in SC from O(N) --> O(1).

        char chArr[] = Integer.toString(num).toCharArray();

        int[] maxRight = new int[10];
        for(int i=0;i<chArr.length;i++){
            int elem = (int)(chArr[i]-'0');
            maxRight[elem] = i;
        }

        // So I have stored each index position in the maxRight array.

        for(int i=0;i<chArr.length;i++){
            for(int j=9;j>(chArr[i]-'0');j--){
                if(maxRight[j]>i){
                    char temp = chArr[i];
                    chArr[i] = chArr[maxRight[j]];
                    chArr[maxRight[j]] = temp;
                    return Integer.parseInt(new String(chArr));
                }
            }
        }
        return num;


        // Optimised and Clean code from other person :-
        // char[] s = Integer.toString(num).toCharArray();
        // int[] last = new int[10];
        // for (int i = 0; i < s.length; i++) last[s[i] - '0'] = i;

        // for (int i = 0; i < s.length; i++) {
        //     for (int d = 9; d > s[i] - '0'; d--) {
        //         if (last[d] > i) {
        //             char temp = s[i];
        //             s[i] = s[last[d]];
        //             s[last[d]] = temp;
        //             return Integer.parseInt(new String(s));
        //         }
        //     }
        // }
        // return num;


    }
}
