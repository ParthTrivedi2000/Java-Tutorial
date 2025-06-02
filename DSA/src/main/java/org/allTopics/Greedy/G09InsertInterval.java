package org.allTopics.Greedy;

// problem Link :- https://leetcode.com/problems/insert-interval/description/

// Problem Description :-
/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still
does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:
0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^5
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 10^5
 */

import java.util.ArrayList;
import java.util.List;

public class G09InsertInterval {
    public static void main(String[] args) {}

    // TC:- O(N), SC:- O(N) to return ans
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        for(int i=0;i<intervals.length;i++){
            // new interval falling after current interval i.e. rightSide.
            if(newStart>intervals[i][1]) ans.add(new int[]{intervals[i][0], intervals[i][1]});
                // new interval falling before current interval i.e. leftside
            else if(newEnd<intervals[i][0]){
                // so adding new interval and since last me hm add kr rhe h new intervals ko
                // in case last tk overlapping rhe, to hr bar sare test cases me last wale
                // intervals nh add ho rhe h & same intervals hi add ho rhe h.
                // So changing values of newStart & newEnd when new Interval is falling on left.
                ans.add(new int[]{newStart,newEnd});
                newStart = intervals[i][0];
                newEnd = intervals[i][1];
            }
            // overlapping
            else{
                newStart = Math.min(newStart,intervals[i][0]);
                newEnd = Math.max(newEnd,intervals[i][1]);
            }
        }
        ans.add(new int[]{newStart,newEnd});

        int[][] res = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
