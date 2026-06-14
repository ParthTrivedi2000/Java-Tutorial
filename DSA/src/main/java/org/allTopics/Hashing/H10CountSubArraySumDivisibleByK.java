package org.allTopics.Hashing;

// Problem Link :-https://leetcode.com/problems/subarray-sums-divisible-by-k/description/

// Problem Description :-
/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible
by k.

A subarray is a contiguous part of an array.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:
Input: nums = [5], k = 9
Output: 0

Constraints:
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
 */

import java.util.HashMap;
import java.util.Map;

public class H10CountSubArraySumDivisibleByK {
    // Concept  :-
    // So since suppose arr is [1,2,3,4,5,6,7,8,9] (consider all these as indexes not the
    // values of the array since I just want to explain the concept)
    // so template is:- for any question if it was asking
    // - number/count/length/longest length of Subarray
    // with some conditions like:- Sum/difference/divisible/XOR by/with K
    // then:- see you have whole array. and abhi aasani se smjne k liye we will take example of sum condition.
    // now just assume for example koi ek subarray ye condition ko follow kr rha h. it means uska koi ek subarray from i to j having sum=K. so what does it mean is, for remaining array, it will be having totalSum-K ryt. so here since hme pta nhi h ki konse sub array ka sum k ho rha he to hme sare subarray ke liye i.e. each subarray k liye uske ander wale sare elems ka sum hona chaiye ryt. and wo kisme possible he prefixSum me ryt. so manlo ki ids=0 se 4 tk ka sum he abhi mre pass to usme se koi particular portion subarray ka sum K ho skta h (nhi b ho skta) i.e. total/prefixSum-K remaining portion k liye present ho skta h. to kehne ka mtlb ye h ki hme actual me pta nhi he ki konse particular portion i.e. subarray from whole array is having Sum==K i.e. wo hmare pass unknown hi he, but hmare pass ek hi variable known he wo he i se leke j tk ka totakSum/prefixSum. to hme kuch aese sochna pdega ki prefixSum ko use krte hue me kuch equation bnau taki muje sum mil jaye. i.e. upr jese hmne discuss kiya wese, hme ye nhi pta h ki knse subArray ka total/prefixSum=k he, but hme itna pta he ki agr koi subarray ka K he to remaining subArray ka prefixSum-K he, simple!!! to yha pe prefixSum to hmne known he hi ryt, and K bhi as a target kuch diya hua he it means yha pe kuch equation hmne bna liya prefixSum-K portion wale subArray ko dhudhne ka it means eventually remaining Array portion ka K sum hoga. iss tarike se ye template wale sare questions solve hote he. to kul mila ke uske liye hme prefixSum ko store krne k liye HashSet/HashMap use krna pdega ryt.
    // to ye upr diye gye template wale type ke koi bhi question hoge usme yhi solution follow krna he.
    // And since ye question is falling under this question we will use above concept to find the solution.



    // But I think pehle wala question sum wala thoda easy tha. I mean usme ek aesa subarray jiska sum k he, to remaining subarray portion jiska sum totalSum-k ho wesa subarray find krna tha simple!!!

    // but yha pe we have the condition like jo subArray ka sum%5 ho rha he wese sare array ka count find krna he ryt. to isko kese hm nikal skte he let's se. so for example suppose arr=[1,2,3,4,5,6,7,8,9] (ye bhi indexes he, means actual values nhi h just for understanding). so now suppose, there is subarray from idx 6 to 9 which is having sum%k=0 ho rha h. so baki ka remaining subArray se kuch connection nikalna pdega ryt.  so for example randomly iteration me koi subArray h, uska wo index tk ka totalSum=21 h. for example in above array, idx 6th. i.e. 6th tk ka sum 21 he. and suppose 0 se 6 ke ander koi subArray h jiska sum%5=0 he. to totalSum ko hm aese likh skte he ki totalSum = 5x + y ryt. it means y is remainder ryt. to means khi na khi usme ek subarray he jiska sum ya to 5/10/15/20 hoga ryt. to remaining subarray ka sum (jese hmne last time wese hi backtrack/reverse engineering kiya tha ryt similarly yha pe bhi wese hi krenge) 21-5/10/15/20 = 16/11/6/1 hoga ryt. abhi yha pe ek cheeze observe kro. I mean see, agr aap 6th idx tk ka jo sum he usko modulo k kroge i.e.21%5 = 1. and usme suppose ek subArray aesa he jiska sum 5/10/15/20 he,to remaining subArray he uska sum i.e. 16/11/6/1 uska modulo 5 se kroge to bhi remainder=1 hi aa rha h.
    // And ye upr jo explain kiya wo actual me simple maths he. see for example abhi koi subArray 0 to 6th idx ka sum = 21 he. so total sum ko aap likh skte ho, 21=5x+y ryt bec usme koi ek subArray h wo sum%5 wala h. but agr remaining wala he wo bhi %5 krne pe remainder same de rha he ryt i.e. remaining subArray ka sum%5=y means 5x+y. i.e. agr 21%5 wali remainder pehle dekhi gyi h i.e. remainder=1 pehle dekhi gyi h, then we can say that there will be some subArray jiska sum%5 wala he usme. kyuki see yha pe kse hoga ki,
    // sum with modulo k + remaining Sum = 21 = 5x+y
    // it means remaining Sum contains that y remainder portion + some sum
    // issliye hme ye dekhna he ki wo 21 ka k se modulo krne pe jo remainder aa rhi h wo isse pehle aa chuki he ki nhi? agr ha it means hmare pass aesa subArray h ki jiska sum%k=0 ho rha ho.



    // So now long story short, coming to conclusion, yha pe hme ye krna pdega ki har bar sum ka modulo lete hue iterate krte jayenge and remainder store krte jayenge map me. agr koi iteration me remainder previosuly mili hogi i.e. we were having sum%k wala subArray somewhere between that 2 indexes. And also we need to store the frequency of that remainder since we want to know the count of that sum%k wale subarrays so.

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int cnt=0;
        int sum=0;
        int remainder=0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            remainder=sum%k;
            if(remainder<0) remainder+=k;
            // else remainder = sum%k;
            if(mp.containsKey(remainder)) cnt+= mp.get(remainder);
            mp.put(remainder,mp.getOrDefault(remainder,0)+1);
        }
        return cnt;
    }
}

