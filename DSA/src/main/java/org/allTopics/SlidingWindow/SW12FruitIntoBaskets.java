package org.allTopics.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

// Q-11) Fruits into Basket:-

// Problem Link :- https://leetcode.com/problems/fruit-into-baskets/description/

// Problem Description :-
/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented
by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

- You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of
fruit each basket can hold.
- Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.
- Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
- Given the integer array fruits, return the maximum number of fruits you can pick.


Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:
Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

Constraints:
1 <= fruits.length <= 10^5
0 <= fruits[i] < fruits.length

 */

public class SW12FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        // Approach - 1:-
        /*
        // Bruteforce:- Using 2 nested loops:- TC:- O(N^2), SC:- O(N)
        Map<Integer, Integer> mp;
        int ans=0;
        for(int i=0;i<fruits.length;i++){
            mp = new HashMap<>();
            for(int j=i;j<fruits.length;j++){
                mp.put(fruits[j], mp.getOrDefault(fruits[j],0)+1);
                if(mp.size()>2) break;
                ans = Math.max(ans,j-i+1);
            }
        }
        return ans;

         */

        // Approach - 2:- Sliding window:-
        int i=0;
        int j=0;
        Map<Integer, Integer> mp = new HashMap<>();
        int ans=0;
        while(j<fruits.length){
            mp.put(fruits[j], mp.getOrDefault(fruits[j],0)+1);
            if(mp.size()>2){
                mp.put(fruits[i],mp.get(fruits[i])-1);
                if(mp.get(fruits[i])==0) mp.remove(fruits[i]);
                i++;
            }
            else{
                ans = Math.max(ans,j-i+1);
            }
            j++;
        }
        return ans;
    }
}
