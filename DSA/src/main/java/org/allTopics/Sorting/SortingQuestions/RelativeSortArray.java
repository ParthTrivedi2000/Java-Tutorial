package org.allTopics.Sorting.SortingQuestions;

// Problem link :- https://leetcode.com/problems/relative-sort-array/description/

/*
Problem Description:-
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:
Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]

Constraints:
1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
All the elements of arr2 are distinct.
Each arr2[i] is in arr1.
 */

import java.util.*;

public class RelativeSortArray {
    Map<Integer,Integer> mp = new HashMap<>();
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        for(int i=0;i<B.size();i++) mp.put(B.get(i),i);

        Collections.sort(A, new OrderOfB());
        return A;
    }
    public class OrderOfB implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if(mp.containsKey(a) && mp.containsKey(b)) {
                return mp.get(a) - mp.get(b);
            }
            else if(mp.containsKey(a)) {
                return -1;
            }
            else if(mp.containsKey(b)) {
                return 1;
            }
            return a-b;
        }
    }

    // Solution from Scaler:-
    /*
    public ArrayList < Integer > solve(ArrayList < Integer > A, ArrayList < Integer > B) {
        TreeMap < Integer, Integer > mp = new TreeMap < Integer, Integer > ();
        // stores the frequency of the elements of A
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            if (mp.get(x) == null) {
                mp.put(x, 1);
            } else {
                mp.put(x, mp.get(x) + 1);
            }
        }
        ArrayList < Integer > ans = new ArrayList < Integer > ();
        for (int i = 0; i < B.size(); i++) {
            int y = B.get(i);
            // checks if y exists in A
            if (mp.get(y) != null) {
                while (mp.get(y) > 0) {
                    ans.add(y);
                    mp.put(y, mp.get(y) - 1);
                }
            }
        }
        Set < Integer > keys = mp.keySet();
        // append the elements that are not present in B
        for (Integer key: keys) {
            int t = mp.get(key);
            while (t > 0) {
                ans.add(key);
                t--;
            }
        }
        return ans;
    }

     */

    // For better understanding, go through all the 3 approaches once:-
    // https://leetcode.com/problems/relative-sort-array/solutions/5293311/3-easy-interview-approaches-brute-force-hashmap-count-sort-beat-all-language/
}
