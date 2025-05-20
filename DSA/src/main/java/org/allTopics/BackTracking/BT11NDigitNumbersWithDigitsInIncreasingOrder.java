package org.allTopics.BackTracking;

// Problem Link :- https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1

// problem Description :-
/*
Given an integer n, print all the n digit numbers in increasing order, such that their
digits are in strictly increasing order(from left to right).
Example:-
Input:
Input:
n = 2
Output:
12 13 14 15 16 17 18 19 23....79 89
Explanation:
For n = 2, the correct sequence is
12 13 14 15 16 17 18 19 23 and so on
up to 89. Single digit numbers are considered to be
strictly increasing order.
Expected Time Complexity: O(9^n)
Expected Auxiliary Space: O(n)
Constraints:
1 <= n <= 9

 */

import java.util.ArrayList;

public class BT11NDigitNumbersWithDigitsInIncreasingOrder {
    public static void main(String[] args) {}

    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(n == 1){
            for(int i=0; i<=9; i++) ans.add(i);
            return ans;
        }
        recForIncreasingNumbers(ans, temp, n, 0);
        return ans;
    }
    public static void recForIncreasingNumbers(ArrayList<Integer> finalList, ArrayList<Integer> temp, int n, int start){
        if(n == 0){
            int ans = 0;
            for(int i=0; i<temp.size(); i++) ans = ans * 10 + temp.get(i);
            finalList.add(ans);
        }
        for(int i = start + 1; i<=9; i++){
            temp.add(i);
            recForIncreasingNumbers(finalList, temp, n - 1, i);
            temp.remove(temp.size() - 1);
        }
    }
}
