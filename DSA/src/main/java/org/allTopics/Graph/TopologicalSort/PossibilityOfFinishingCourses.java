package org.allTopics.Graph.TopologicalSort;

// Problem Link :- https://leetcode.com/problems/course-schedule/description/

/*
Problem Description :-
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So
it is impossible.


Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PossibilityOfFinishingCourses {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] ans = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        int idx=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[idx]=curr;
            idx++;
            for(int i=graph.get(curr).size()-1;i>=0;i--){
                int elem=graph.get(curr).get(i);
                indegree[elem]--;
                if(indegree[elem]==0) q.add(elem);
            }
        }

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]!=0) return false;
        }
        return true;
    }
}
