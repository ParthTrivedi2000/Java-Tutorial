package org.allTopics.SlidingWindow;

import java.util.*;

public class SlidingWindow {
/*

Identification:-
So as we have discussed, how to identify like in this particular problem I can apply
sliding window concept is, generally if below conditions you find in any of the problem
statement, you can implement sliding window.
- Generally these are of problems related to array/string.
- in problem statement they are asking to find subarray/ substring then you should think of
implementing sliding window.
- in problem statement either you will be given certain windowSize/ condition to find subarray/
substring or they are asking to find something from subarray/substring based on condition given.

## General format of Fixed size sliding window:-
int i=0;
int j=0;
while(j<n){
    // perform Calculations on jth positioned elems
    if(j-i+1<windowSize){ j++; }
    else if(j-i+1 == windowSize){
        // 1) get the ans from the calculations we have done
        ans = Math.max(ans,j-i+1);
        // 2) Before sliding the window, remove the impact of prev i.
        sum = sum-arr[i];
        // 3) Slide the window
        i++;
        j++;
    }
}

## General format of Variable Size Sliding Window.
int i=0;
int j=0;
while(j<n){
    // Perform calculations
    //if condition is less than
    if(sum<k) {j++;}
    // if condition is true
    else if(condition==k){
        // get the answer from the calculations done so far
        ans=Math.max(ans,j-i+1);
        // expand the window
        j++;
    }
    // if condition is false
    else if(condition>k){
        // remove the impact of prev i's by shrinking the window.
        while(sum<k){
            sum=sum-arr[i]
            // shrink the window
            i++;
        }
        // expand the window
        j++;
    }

}
*/

/*
Q - 1) Maximum Sum SubArray of size K.

Problem Link:- https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

Problem Statement:- Given an array of integers Arr of size N and a number K. Return the
maximum sum of a subarray of size K.

Identification:-
-Problem is related to array.
- in problem statement, they are asking to do something to do on subarray.
- windowSize is given as K.
So we can see like we have to apply Sliding Window concept here.

Example:-
Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Arri <= 105
1 <= K <= N

 */
    public long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N){

        int i = 0; // represents start of window/subarray
        int j = 0; // represents end of the window/subarray
        long sum=0;
        long ans = Long.MIN_VALUE;
        while(j<Arr.size()){
            // calculaation
            sum+=Arr.get(j);

            // till the moment end of window(i.e. here j) is smaller than windowSize,
            // we can just expand the window ryt. nothing else needs to be done. bec
            // whatever we want to achieve that we have done in above calculation part
            // generaically like that thing needs to be done anyhow weather I am reaching
            // windoSize or not. So we kept it generaic. then we are having 2 things now,

            // end of window <windowSize --> just increase the end i.e. expand the window
            if(j-i+1<K) j++;
                // end of window==windowSize
                // At the time when end of the window is euqals to windowSize, we should try
                // to find our o/p based on calculations we have done above.
            else if(j-i+1==K){
                ans = Math.max(sum,ans);
                // After getting possible output, we need to shrink our window from left
                // to just move ahead till the end o the array. but before shrinking it
                // (i.e. i++), we just need to remove the impact of i from window which
                // we have considered. bec we are now going for next window ryt so
                // obviously we have to consider everything for the elems present in
                // current window only.

                // so nullyfying previous elems impact from current window.
                sum = sum- Arr.get(i);

                // Now move/slide the current window to next window
                i++;
                j++;
            }
        }
        return ans;
        // Accha one more thing as we have kept calulation generic in above case, it is
        // not necessary to keep as generic. i mean in some cases we have to perform
        // calculation for till end <windoSize. then in those cases we kept clculation in
        // end<windowSize block only. But smjne ki bat ye h ki 2 hi cheeze hogi aesa like
        // end<windowSize and end==windowSize
    }

/*
Q - 2) First negative in every window of size k
Problem Link :- https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

Problem Statement:- Given an array A[] of size N and a positive integer K, find the first
negative integer for each and every window(contiguous subarray) of size K.

Example :-
Input :
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output :
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)

Constraints:
1 <= N <= 105
-105 <= A[i] <= 105
1 <= K <= N
 */
    public long[] printFirstNegativeInteger(long A[], int N, int K){

        //BruteForce :-
//        int[] ans = new int[N-K+1];
//        for(int i=0;i<A.length;i++){
//            for(int j=i;j<i+K;j++){
//                if(A[j]<0) ans[i] = A[j];
//                else ans[i] = 0;
//            }
//        }
//        So what happens here is, like we are doing repetitive things how? measn suppose array given
//        is 12,-1,-7,8,-10,30,17,25
//        So when we have started my loop, i will be at 0th index. then we have checked like element is
//        -ve or not for next 3 elems. then i++ will be happen. then again in above case durin 2nd
//        iteration we are checking for elems -1 & -7. But we have already checked it during 1st iteration
//        But still we are checking and same thing will happen till the end of the loop. this is how
//        Repetative work is done. (Pls explain to the interviewer if possible).

//        So now we need to improve this. Accha and remember 1 thing, for all the Sliding Window problem
//        we were doing repetative work in bruteforce approach then to improve it we are going with
//        optimal approach sliding window.

//        Optimal Appraoch:- TC:- O(N), SC:O(N)
        int i=0;
        int j=0;
//         As per use case here I want to store all the -ves while moving ahead ryt. So now which DS I should
//        use. measn just think here what I want to do is, when I am moving forward, I have to store the
//        -ve values. see we are only moving for windowSize, so wo windowSize me jitni bhi -ve value hogi wo
//        add ho jayegi DS m...but usme se muje to 1st wali h whi chahiye ryt...and during next time as well
//        when I am sliding the window, my DS should store only -ves which are currently in current window.
//        So I hae to remove the -ve of previous window if it's present. So I have to choose DS in which I can
//        perform both of the above thing.
//        So if you think carefully, here I want 1st elem added. i.e. 1st In 1st out type structure (FIFO).
//        So I can have Queue.
//        But here if I think, I just want to remove the starting elem, that I can achieve via List DS as well
//        So either Queue/List would be fine here for above problem.
        List<Long> negatives = new ArrayList<>();
        long[] ans = new long[N-K+1]; // to store and return the answer
        while(j<N){
            // calculations
            if(A[j]<0) negatives.add(A[j]);

            if(j-i+1<K) j++;

            else if(j-i+1==K){
                // finding ans from calculations done till now
                if(negatives.size()==0) ans[i]=0; // if list is empty, i.e. there is no -ve elem in current
                //window since it is tracking the current window elems only so.
                else ans[i] = negatives.get(0);

//                Nullyfying impact of prev i
                if(A[i]<0) negatives.remove(0);
//                Slide the window
                i++;
                j++;
            }
        }
        return ans;
    }

/*
Q-3) Count Occurrences of Anagrams
Problem Link :- https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

Problem Statement:- Given a word pat and a text txt. Return the count of the occurrences of anagrams
of the word in the text.

Example:-
Input:
txt = forxxorfxdofr
pat = for
Output: 3
Explanation: for, orf and ofr appears
in the txt, hence answer is 3.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(26) or O(256)

Constraints:
1 <= |pat| <= |txt| <= 105
Both strings contain lowercase English letters.
 */
    int search(String pat, String txt) {
        // code here
        int windowSize = pat.length();
         // 1st let's create a Map to store the frequency of given string pat.
         // Then I have to check in txt string like weather this whole string is present
         // in String txt or not.
         // creating map to store the frequency of each characters of given patterns
         // so that we can use it to check for anagrams.
         Map<Character,Integer> mp = new HashMap<Character,Integer>();
         char ch = '0';
         for(int k=0;k<windowSize;k++){
             ch = pat.charAt(k);
             if(mp.containsKey(ch)){
                 mp.put(ch,mp.get(ch)+1);
             }
             else{
                 mp.put(ch,1);
             }
         }

         // As we don't want to traverse on whole map everytime, we have initialised the count
         // Variable. and it will have all the distinct keys. as soon as value corresponding to
         // any key becomes 0 then we can reduce count as well.
         // Since I don't want to traverse the Map each time, I am using count variable
         // to increase/decrease when any element of Map hits zero or again come back to>0 state
         int count = mp.size();

         // Hence benefit will be, whenever my j= windowsize condition match, at that time if this
         // count becomes 0 then I can say like all the letters are covered from given pat string.
         int i = 0;
         int j = 0;
         int ans = 0;
         while(j<txt.length()){
             // Calculations:-

             // Removing chars from Map if i found in current window. and don't worry means
             // at last when we are about to slide window,just before that we perform
             // calculations for i. So at that time we perform reverse operations
             // means we will add the ith char in map and do corresponding change in count var.

             // Removing chars from Map if i found in current window
             if(mp.containsKey(txt.charAt(j))){
                 mp.put(txt.charAt(j),mp.get(txt.charAt(j))-1);
                  // And whenever next window comes, I don't want to traverse map again to save
                  // the time complexity. hence using this count variable to track like any elem's
                  // frequency becomes 0 or not in the Map.
                 if(mp.get(txt.charAt(j))==0) count--;
             }

             if(j-i+1<windowSize){
                 j++;
             }
             else if(j-i+1 == windowSize){
                 if(count==0) ans++;

                 // nullyfying impact of current i on next ith iteration before sliding the window
                 if(mp.containsKey(txt.charAt(i))){
                     if(mp.get(txt.charAt(i))==0) count++;
                     mp.put(txt.charAt(i),mp.get(txt.charAt(i))+1);
                 }
                 // Slide the Window
                 i++;
                 j++;
             }
         }
         return ans;
    }

/*
Q - 4) Maximum of all subarrays of size K
Problem Link:- https://leetcode.com/problems/sliding-window-maximum/description/

Problem Statement:-
You are given an array of integers nums, there is a sliding window of size k which is moving from the very
left of the array to the very right. You can only see the k numbers in the window. Each time the sliding
window moves right by one position. Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

 */
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Why we are using queue data structure here instead of simply using one max variable or
        // 2 variables 1st to store max and 2nd to store secondMax?
        // Please understand, here we can use max variable. but the point when we are sliding the
        // window (i.e. i++), at that time if the element at i is maximum and we are sliding to next
        // elem. it means that elem  on previous i is not now max in new window. so we need to remove
        // it ryt. and at that time we want 2nd maximum, or we can say maximum from remaining window
        // element before adding new element to window(i.e. before j++).  so here if we are using
        // 2nd max variable then it will store it for 1st window only. then but we want this thing to be
        // done for each and every window on which we are iterating. so we have to store max and all
        // the smaller than max from ryt side of jth element. that's why we can't use just simply 2
        // variables and instead we are using doubly ended queue open from both ends.

        // ArrayList<Integer> ans = new ArrayList<>(); // To store answer
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<>(); // doubly ended open queue from both sides
        int i=0;
        int j=0;
        while(j<nums.length){

            // Calculations:-
            // So in calculation what we need to do is, we have to put the element in the queue
            // data structure. but main thing is we don't want to put all the elems in the queue
            // ryt? we want to put all the smaller element from j and of right side of j only from
            // current one window. not the left side of smaller elements.

            // To remove elems
            while(queue.size() > 0 && queue.peekLast()<nums[j]){
                queue.removeLast();
            }
            // Adding max to queue
            queue.addLast(nums[j]);

            // As discussed, we will be having max always at front of queue, hence picking it and
            // adding it to final answer ds.
            // ans.add(queue.peekFirst());

            if(j-i+1<k) j++;

            else if(j-i+1==k){
                // 1) fetching ans from calculation.
                // ans.add(queue.peekFirst());
                ans[i] = queue.peekFirst();

                // 2) Nullyfying impact of previous i
                if(queue.peekFirst()==nums[i]){
                    queue.removeFirst();
                }
                // 3) Slide the window
                i++;
                j++;
            }
        }

        // Integer[] ans1 = ans.toArray();
        return ans;

// Below code is failing at line 389, don't know why...
//        int max=arr[0];
//        List<Integer> maxis = new ArrayList<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//
//        // For the 1st window
//        for(int i=0;i<k;i++){
//            if(arr[i]>max) max=arr[i];
//        }
//        maxis.add(max);
//
//        // for remaining windows
//        int z=0;
//        int i = 1;
//        int j = k;
//        while(j<n){
//            if(arr[j]>maxis.get(0)) maxis.add(arr[j]);
//            // Fetching ans from calculations done so far.
//            ans.add(maxis.get(0));
//            // nullyfying the impact of prev i
//            if(arr[i]>=maxis.get(0)) maxis.remove(0);
//            // Sliding the window
//            i++;
//            j++;
//        }
//        return ans;
    }

/*
Q - 5) Longest Subarray of Sum K :-
Problem Link :- https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

Problem Statement :- Given an array arr containing n integers and an integer k. Your task is to find
the length of the longest Sub-Array with the sum of the elements equal to the given value k.

Example :-
Input :
arr[] = {10, 5, 2, 7, 1, 9}, k = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1<=n<=10^5
-10^5<=arr[i], K<=10^5

 */
    public static int lenOfLongSubarr (int A[], int N, int K) {
        // Starting window
        int i = 0;
        int j = 0;
        long sum = 0;
        int maxLen = 0;
        while (j < N) {
            // Calculations:-
            sum = sum + A[j];
            // Checking condition is met or not.
            if (sum < K) {
                j++;
            }
            // Checking condition is met or not. Once it met, need to store ans from calculation.
            else if (sum == K) {
                // fetching ans from calculation
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else if (sum > K) {
                while (sum > K) {
                    // Nullyfying impact of prev i
                    sum = sum - A[i];
                    // Shrinking window
                    i++;
                }
                // expanding window
                j++;
            }
        }
        return maxLen;
/*
Q). Will the above discussed approach work with negative numbers in the array?
A. No.
Because let's say in the given array [4,1,1,1,2,3,5] when we found the sum within the window to be
greater than the desired value 5 (i=0, j=2 -> [4,1,1]), we started reducing the size of the window by
doing i++. Here we assumed that once the sum of elements within the window becomes greater than 5 then
increasing the window size will just add to the sum and hence we will not attain the sum 5 again. This is
true when all the element are positive and hence reducing the window size by doing i++ makes sense. But
this might not be true if array also contains negative numbers. Consider the array [4,1,1,-2,1,5], here we
would have found the sum to be greater than 5 for i=0, j=2 and if we would have now started reducing the
window size by doing i++, we would have missed the potential subarray (i=0, j=4).
In short, the discussed approach will not work with array having negative numbers.
 */
    }

/*
Q - 6) Longest Substring with K unique characters.
Problem Link :- https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

Problem Statement :- Given a string you need to print the size of the longest possible substring that
has exactly K unique characters. If there is no possible substring then print -1.

Example :-
Input:
S = "aabacbebebe", K = 3
Output:
7
Explanation:
"cbebebe" is the longest substring with 3 distinct characters.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).

Constraints:
1 ≤ |S| ≤ 10^5
1 ≤ K ≤ 26
All characters are lowercase latin characters.
 */
    public int longestkSubstr(String s, int k) {
        // code here
        // Adity Verma's Template :-
        /*
            // We will use Map ds instead of Set to store these unique chars. bec in map we can keep track
            // of count as value corresponding key as character. and we can use it further.
            int i=0;
            int j=0;
            int maxLen = -1;
            char ch = '0';
            // Set<char> hash_set = new HashSet<>();
            HashMap<Character,Integer> mp = new HashMap<>();
            while(j<s.length()){
                ch = s.charAt(j);
                if(!mp.containsKey(ch)) {//add key as char nd value as 0
                    mp.put(ch,1);
                }
                else{//update the value corresponding key by 1
                    mp.put(ch,mp.get(ch)+1);
                }
                if(mp.size()<k){
                    j++;
                }
                else if(mp.size()==k){
                    maxLen = Math.max(maxLen,j-i+1);
                    j++;
                }
                else if(mp.size()>k){
                    while(mp.size()>k){
                        mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                        if(mp.get(s.charAt(i))==0){
                            mp.remove(s.charAt(i));
                        }
                        i++;
                    }
                     j++;
                }
            }
            return maxLen;
        */

        // Striver's template:-
        int i=0;
        int j=0;
        int maxLen = -1;
        char ch = '0';
        Map<Character,Integer> mp = new HashMap<>();
        while(j<s.length()){
            ch = s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)+1);
            }else{
                mp.put(ch,1);
            }
            if(mp.size()>k){
                mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                if(mp.get(s.charAt(i))==0){
                    mp.remove(s.charAt(i));
                }
                i++;
            }
            else if(mp.size()==k){
                // if (mp.size()==K)
                maxLen = Math.max(maxLen,j-i+1);
            }
            j++;
        }
        return maxLen;
    }


/*
Q - 7) Longest Substring Without Repeating Characters :-
Problem Link :- https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Problem Statement:- Given a string s, find the length of the longest substring without repeating characters.
Example:-
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
    public int lengthOfLongestSubstring(String s) {
//        // Brute force Approach :-
//        // Generate all the substring and check for the given condition.
//        int len = 0;
//        int maxLen = Integer.MIN_VALUE;
//        for(int i=0;i<s.length();i++){
//        //  we can use set as well. purpose of this DS is to check weather the current char is previously visited
          //  or not.
          //  Set < Character > se = new HashSet < > ();
//            int[] visited = new int[256];
//            for(int j=i;j<s.length();j++){
//                if(visited[s.charAt(j)]==1) break; // if any char is encountered 2nd time, then we just need to
//                // break that substring. And we can store the length till that particular char.
//                len = j-i+1;
//                maxLen = Math.max(len,maxLen);
//                visited[s.charAt(j)] = 1; // marking this char at visited
//            }
//        }
//        return maxLen;
//        // TC of above approach:- O(N^2),  SC:-O(256)

        // working & tested code per Aditya Verma's template
        int i=0;
        int j=0;
        int ans = 0;
        Map<Character,Integer> mp = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            if(!mp.containsKey(ch)) mp.put(ch,1);
            else mp.put(ch,mp.get(ch)+1);

            // While condition is true
            if(mp.size()==j-i+1){
                ans = Math.max(ans,j-i+1);
                j++;
            }
            else if(mp.size()<j-i+1){
                // remove impact of prev i
                while(mp.size()<j-i+1){
                    if(mp.containsKey(s.charAt(i))) mp.put(s.charAt(i),mp.get(s.charAt(i))-1);
                    if(mp.get(s.charAt(i))==0) mp.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return ans;

        // Striver's Solution.
        // Approach - 3:- using a hashArray(instead of Map) & Sliding window.
//        int i=0;
//        int j=0;
//        int maxLen = 0;
//        char ch = '0';
//
//        int[] hash = new int[256];
//        for(int p=0;p<hash.length;p++){
//            hash[p] = -1;
//        }
//        // Starting sliding window algo
//        while(j<s.length()){
//            ch = s.charAt(j);
//            if(hash[ch]!=-1 && hash[ch]>=i) {
//                i=hash[ch]+1;
//            }
//            maxLen = Math.max(maxLen,j-i+1);
//            hash[ch] = j;
//            j++;
//        }
//        return maxLen;

// Note:- Highly recommend to go through this article once. In this striver has used Map to store the char and updated
//        indexes instead of frequency. So we can directly update it with new index in case we found 2nd time.
//        And whenever get time, just implement code here all the 3 approaches with explanation/your understanding.
//        https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
    }

/*
Q - 7) Pick Toys :-
Problem Statement :- No it's not given anyWhere, it was an interview problem. statement is something like below.
John is at a toy store. help him pick maximum number of toys. He can only select in a continuous manner
and he can select only two types of toys.

Example:
Input:- string will be given
abaccab
o/p:- 4

So as per my opinion, this question we can re state as,
Find the Longest Substring with 2 distinct characters.
Please see the solution in one of the above question. just put k=2 over there.
 */


/*
Q -8) Minimum Window Substring
Problem Link:- https://leetcode.com/problems/minimum-window-substring/description/
Problem Description:- Given two strings s and t of lengths m and n respectively, return the minimum window
substring of s such that every character in t (including duplicates) is included in the window. If there
is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
    // As per Aditya Verma's Sliding Window Approach:-
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(!mp.containsKey(t.charAt(i))) mp.put(t.charAt(i),1);
            else mp.put(t.charAt(i),mp.get(t.charAt(i))+1);
        }
        int count=mp.size();
        int i=0;
        int j=0;
        int ans=Integer.MAX_VALUE;
        int temp=0;
        int startIndex = -1;
        int endIndex=-1;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(mp.containsKey(ch)){
                mp.put(ch, mp.getOrDefault(ch,0)-1);
                if(mp.get(ch)==0) count--;
            }
            if(count>0) j++;
            else if(count==0){
                temp=ans;
                ans=Math.min(ans,j-i+1);
                if(temp!=ans)
                    startIndex=i;
                while(count==0){
                    // char c2=s.charAt(i);
                    if(mp.containsKey(s.charAt(i))){
                        mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
                        if(mp.get(s.charAt(i))==1) count++;
                    }
                    // Shrinking Window
                    i++;
                    if(count==0){
                        ans=Math.min(ans,j-i+1);
                        if(temp!=ans)
                            startIndex=i;
                    }
                }
                j++;
            }
        }
        if(ans==Integer.MAX_VALUE) return("");
        return s.substring(startIndex,startIndex+ans);
    }




    
/* Striver's Sliding Window & 2 Pointers Questions continued....
 */

/*
Q - 9) Maximum points you can obtain from cards
Problem Link :- https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

Problem Description:-
There are several cards arranged in a row, and each card has an associated number of points. The points
are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take
exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Example 1:
Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card
first will maximize your total score. The optimal strategy is to take the three cards on the right,
giving a final score of 1 + 6 + 5 = 12.

Constraints:
1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length
 */
    public int maxScore(int[] cardPoints, int k) {
        // Approach:-
        // 1st I can have the sum of 4 cards from starting.
        // Then I can have 2 pointers.
        // i pointer will be placed at K-1th index. and j pointer will be placed at the last index.
        // Then I can add the last elem to the sum & parallel remove the elem at i from sum. and finding
        // maximum each time. will continue this process k times or we can say till i becomes 0.

        int sum=0;
        // Taking sum of starting k elements
        for(int i=0;i<k;i++) sum+=cardPoints[i];

        int ans=sum;
        // Start considering elems from back.
        for(int i=k-1,j=cardPoints.length-1; i>=0;i--,j--){
            sum = sum + cardPoints[j] - cardPoints[i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }

// Next question is Longest Substring without repeating characters. Please check Question-7 above.

}

