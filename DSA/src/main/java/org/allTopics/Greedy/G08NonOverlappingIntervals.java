package org.allTopics.Greedy;

// Problem link :- https://leetcode.com/problems/non-overlapping-intervals/description/

// Problem Description:-
/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you
need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Constraints:
1 <= intervals.length <= 10^5
intervals[i].length == 2
-5 * 10^4 <= starti < endi <= 5 * 10^4

 */

import java.util.Arrays;
import java.util.Comparator;

public class G08NonOverlappingIntervals {
    // TC:- O(NlogN), SC:- O(N)
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] ar1, int[] ar2){
                return ar1[1]-ar2[1];
            }
        });

        int pickInterval=1;
        int endIntervalLength = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=endIntervalLength){
                pickInterval++;
                endIntervalLength=intervals[i][1];
            }
        }
        return intervals.length-pickInterval;
    }
}
