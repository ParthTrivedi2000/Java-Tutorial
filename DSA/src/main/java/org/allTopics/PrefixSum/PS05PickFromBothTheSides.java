package org.allTopics.PrefixSum;

// Problem Link :- https://www.interviewbit.com/problems/pick-from-both-sides/
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

// Problem Statement :-
/*
Given an integer array A of size N.
You have to pick exactly B elements from either left or right end of the array A to get the maximum sum.
Find and return this maximum possible sum.

NOTE: Suppose B = 4 and array A contains 10 elements then
You can pick the first four elements or can pick the last four elements or can pick 1 from the front and 3 from the back etc.
you need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 10^5
1 <= B <= N
-10^3 <= A[i] <= 10^3

Input Format
First argument is an integer array A.
Second argument is an integer B.

Output Format
Return an integer denoting the maximum possible sum of elements you picked.

Example Input
Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:
 A = [1, 2]
 B = 1


Example Output
Output 1:
 8
Output 2:
 2


Example Explanation
Explanation 1:
 Pick element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:
 Pick element 2 from end as this is the maximum we can get

 */

public class PS05PickFromBothTheSides {
    // Optimised Approach:- TC:- O(k), SC:-O(1)
    // This is the standard sliding method: take first k from left, then
    // iteratively replace one taken-from-left element with one taken-from-right.
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int n = cardPoints.length;
        if (k == 0) return 0;
        if (k >= n) {
            int total = 0;
            for (int v : cardPoints) total += v;
            return total;
        }
        for (int i = 0; i < k; i++) sum += cardPoints[i];
        ans = sum;
        for (int i = k - 1, j = n - 1; i >= 0; i--, j--) {
            sum = sum - cardPoints[i] + cardPoints[j];
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * Brute-force approach (naive recomputation)
     * Algorithm:
     * - Enumerate how many elements to take from the front: left = 0..k
     * - right = k - left elements will be taken from the back
     * - For each split, recompute the sum by looping over chosen front and back elements
     * Time Complexity: O(k^2) because for each of k+1 splits we sum up to k elements.
     * Space Complexity: O(1)
     */
    public static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        if (k == 0) return 0;
        if (k >= n) {
            int total = 0;
            for (int v : arr) total += v;
            return total;
        }
        int best = Integer.MIN_VALUE;
        for (int left = 0; left <= k; left++) {
            int right = k - left;
            int sum = 0;
            // sum left elements
            for (int i = 0; i < left; i++) sum += arr[i];
            // sum right elements
            for (int j = n - right; j < n; j++) {
                if (right <= 0) break;
                sum += arr[j];
            }
            if (sum > best) best = sum;
        }
        return best;
    }

    /**
     * Better approach using prefix/suffix arrays (O(k) extra space).
     * Algorithm:
     * - Build leftPrefix[0..k]: leftPrefix[i] = sum of first i elements (0 means 0).
     * - Build rightPrefix[0..k]: rightPrefix[i] = sum of last i elements.
     * - For left = 0..k compute total = leftPrefix[left] + rightPrefix[k-left] and take max.
     * Time Complexity: O(k)
     * Space Complexity: O(k) for the two small prefix arrays.
     */
    public static int betterApproach(int[] arr, int k) {
        int n = arr.length;
        if (k == 0) return 0;
        if (k >= n) {
            int total = 0;
            for (int v : arr) total += v;
            return total;
        }
        // Build left prefix sums up to k
        int[] left = new int[k + 1]; // left[i] = sum of first i elements
        left[0] = 0;
        for (int i = 1; i <= k; i++) left[i] = left[i - 1] + arr[i - 1];

        // Build right prefix sums up to k
        int[] right = new int[k + 1]; // right[i] = sum of last i elements
        right[0] = 0;
        for (int i = 1; i <= k; i++) right[i] = right[i - 1] + arr[n - i];

        int best = Integer.MIN_VALUE;
        for (int leftTake = 0; leftTake <= k; leftTake++) {
            int rightTake = k - leftTake;
            int total = left[leftTake] + right[rightTake];
            if (total > best) best = total;
        }
        return best;
    }

    // Small main() harness to demonstrate and verify both methods on sample cases.
    // Prints results and expected outputs.
    public static void main(String[] args) {
        int[][] tests = {
            {1, 2, 3, 4, 5, 6, 1},
            {2, 2, 2},
            {5, -3, 2, 1}
        };
        int[] ks = {3, 2, 2};
        int[] expected = {12, 4, 6};

        for (int i = 0; i < tests.length; i++) {
            int[] arr = tests[i];
            int k = ks[i];
            int exp = expected[i];

            int brute = bruteForce(arr, k);
            int better = betterApproach(arr, k);
            int instance = new PS05PickFromBothTheSides().maxScore(arr, k);

            System.out.println("Test " + (i + 1) + ": arr=" + java.util.Arrays.toString(arr) + ", k=" + k);
            System.out.println("  Expected: " + exp);
            System.out.println("  bruteForce: " + brute + "  (TC: O(k^2), SC: O(1))");
            System.out.println("  betterApproach: " + better + "  (TC: O(k), SC: O(k))");
            System.out.println("  instance maxScore: " + instance + "\n");
        }

        // Explanation of the common bug the user asked about (concise):
        System.out.println("Note about the common brute-force bug:");
        System.out.println("  Wrong inner loop: for (int j = i; j < k; j++) ...\n" +
                "  Why it's wrong: the condition 'j < k' doesn't depend on i, so after i grows the inner loop range no longer covers the next k elements.\n" +
                "  Correct intent when you want k elements starting at i: use 'j < i + k' (and ensure i + k <= n).\n");
    }
}
