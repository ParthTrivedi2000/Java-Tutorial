package org.allTopics.Greedy;

// Problem Statement:- https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

// Problem Description ;-
/*
You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the
same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is
kept waiting.

At any given time, the same platform cannot be used for both the arrival of one train and the departure of another.
Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are
required to accommodate both trains.

Examples:

Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.
Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exclusive. So we need only one platform
Input: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
Output: 3
Explanation: All 3 trains have to be there from 11:00 to 11:30
Constraints:
1≤ number of trains ≤ 50000
0000 ≤ arr[i] ≤ dep[i] ≤ 2359
Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 )
and the last two characters represent minutes (this will be <= 59 and >= 0).

Expected Complexities
Time Complexity: O(n log n)
Auxiliary Space: O(n)
Company Tags
Paytm Amazon Microsoft D-E-Shaw Hike Walmart Adobe Google Boomerang-Commerce Zillious Atlassian
 */

import java.util.Arrays;

public class G10MinimumNumberOfPlatforms {

    // Logic:-
    /*
    So here since if time is intersecting, and jitni bar intersect ho rha h utne platforms you required. This is the
    logic. Means simply if you find out the no of intersections, then you can say that these much platforms are required.

    So I have to find the no of intersection each single train will be having with remaining rest of the trains.
    And out of that whichever max intersection happens, that max intersection will be my answer.

    Again like here it will take O(N^2) since for each i (i.e train), I will check how many times ith train is intersecting
    with other trains.
    So here for intersections/ to find intersections, there are 4 ways possible.
    - either jth trains start & end time both are in between ith train's start & end time.
    - jth trains arrival time is between ith train's arrival & departure time
    - jth trains arrival is before ith arrival but departure is falling in ith arrival & departure.

    That is very bruteforce approach :- O(N^2), Sc-O(1)

    Better Approach:-
    for above example-1 input arrays:-
    [(900,'A'),(910,'D'),(950,'A')....]
    what we can do is, we can create a separate array/list. And we are just passing the arrival time with 'A' char
    & departure time with 'D' char. Now just iterate on that list, whenever you faces 'A' , increase platform count
    whenever you faces 'D', just decrease the platform count. And whatever maximum platform count you get in-between
    that would be your answer.

    TC:- O(N) + O(2N) , SC:- O(2N)

    Since above approach uses extra space. So we can omit that as well, just by using 2 pointers.

    Optimised:-
    So, see here arrival array is sorted only. But departure array is not sorted. So we will sort it independently.
    Now just put ith pointer on arrival's 0th idx, and put the jth pointer on departure's 0th idx.
    And start traversing.
    check if ith elem <jth elem then increase the paltformCount, else if ithElem>jthElem, decrease the platformCount.


     */

    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here

        // Bruteforce Approach:-
        /*
         int maxIntesrsections = 0;
         for(int i=0;i<arr.length;i++){
             int intersections =  0;
             for(int j=i+1;j<arr.length;j++){
                 if(){ // 3-4 conditions to check the intersections
                     intersections++;
                 }
             }
             maxIntersections = Math.max(maxIntersections,intersections);
         }
         return maxIntersections;
        */


        // // Better approach:-
        // // Failing for this test case:-
        // // arr[] = 2153 659 1721 1025 602 1531 1832 829
        // // dep[] = 2204 1832 1949 2034 1141 2033 1844 1926
        /*
         class Pair{
             int time;
             char specifier;
             Pair(int x, char y){
                 this.time = x;
                 this.specifier = y;
             }
         }

         Pair[] total = new Pair[2*arr.length];
         int idx=0;
         for(int i=0;i<arr.length;i++){
             total[idx] = new Pair(arr[i],'A');
             idx++;
             total[idx] = new Pair(dep[i],'D');
             idx++;
         }

         Arrays.sort(total, (a,b)->a.time-b.time);

         int platform = 0;
         int maxi= 0;
         // for(Pair elem:total){
         for(int i=0;i<total.length;i++){
             if(i-1>0 && total[i].time==total[i-1].time && total[i].specifier!=total[i-1].specifier) platform++;
             else if(total[i].specifier =='A'){
                 platform++;

             }
             else platform--;
             maxi = Math.max(platform,maxi);
         }
         return maxi;

         */


        // Optimised Approach:-
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0;
        int j=0;
        int platform=0;
        int maxi=0;
        while(i<arr.length && j<arr.length){
            if(arr[i]<=dep[j]){
                platform++;
                i++;
            }
            else{
                platform--;
                j++;
            }
            maxi = Math.max(maxi,platform);
        }
        return maxi;
    }

}
