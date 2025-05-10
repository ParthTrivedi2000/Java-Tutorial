package org.allTopics.IntervalPatternQuestions;

// Problem Link :- https://leetcode.com/problems/merge-intervals/description/

// Problem Description :-
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IP01MergeIntervals {
    public int[][] merge(int[][] intervals) {

        // Bruteforce:-
        // - 1st actually we need to sort the intervals based on starting positions.
        // - then simply just start iterating over the intervals array.
        // - for any interval, if you find start2<=end1, i.e. they are overlapping. i.e.
        // for them you have to get the maximum(end1,end2). and move ahead.
        // - now at any place if my start2>end1 i.e. we can stop.
        // and similarly next iterations keep continues.

        // Better/Optimal Approach :-

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0]<arr2[0]) return -1;
                else if (arr1[0]>arr2[0]) return 1;
                else{
                    if(arr1[1]<arr2[1]) return -1;
                    else if(arr1[1]>arr2[1]) return 1;
                    else return 0;
                }
            }
        });

        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(start>intervals[i][1]){
                ans.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            else if(end<intervals[i][0]){
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end = intervals[i][1];
            }
            else{
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }

        }
        ans.add(new int[]{start,end});

        int[][] res = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
