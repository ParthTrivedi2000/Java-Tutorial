package org.allTopics.Graph.TopologicalSort;

// Problem Link :- https://www.geeksforgeeks.org/problems/topological-sort/1

/*
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such
that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed
edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is
not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.
If there is a solution return the correct ordering. If there are multiple solutions print the lexographically
smallest one.
Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f
and so on.

NOTE:

There are no self-loops in the graph.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 104
1 <= M <= min(100000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed
from node B[i][0] to node B[i][1].

Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return
empty array.

Example Input
Input 1:
 A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]
Input 2:
 A = 3
 B = [  [1, 2]
        [2, 3]
        [3, 1] ]


Example Output
Output 1:
 [5, 6, 1, 3, 4, 2]
Output 2:
 []

Example Explanation
Explanation 1:
 The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
Explanation 2:
 The given graph contain cycle so topological ordering not possible we will return empty array.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopologicalSort {
    public int[] topoSort(int A, int[][] B) {
        int n = A;
        int edges[][] = B;

        // so I am passing n nodes and edges in arg. So I have to build graph by
        // myself. this edges array is not graph. but we have to build the graph from nodes and edges.

        // created a graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=A; i++){
            graph.add(new ArrayList<>());
        }
        // created indegree array
        int[] indegree = new int[A+1];

        int m = edges.length;
        // System.out.println(m);
        for(int i=0;i<B.length;i++){
            int u = B[i][0];
            int v = B[i][1];
            // above u and v denotes, there is an edge from u-->--v
            // since it is directed graph, we only have to add at uth index. not on vth index as well.
            graph.get(u).add(v);
            // then since edge is from u to v, I have to increment the vth index in indegree array ryt? pls understand
            // this very well.
            indegree[v]++;
        }
        // So above is my 1st Step completed. What exactly we have done in 1st step.
        // We have just created graph and parallely also created the indegree array. And fill the indegree array parrallely
        // while filling the graph values.

        // Create a Queue. (Here I have run code using normal queue only. but for one of the
        // input([[1,4],[1,2],[4,2],[4,3],[3,2],[5,2],[3,5],[8,2],[8,6]])
        // it was failing. So since they have asked to return the topological order as per the lexicography whatever will be
        // 1st that needs to be return. so we have to use priority queue instead of normal queue
        // to provide the correct lexicographical ordered output).
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> ans = new ArrayList<>();
        // Initialising Queue:-
        // I have to add the elems which has inderee value = 0 in the queue first.
        for(int i=1;i<=A;i++){
            if(indegree[i]==0) q.add(i);
        }

        // let's start main work
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            for(int i=graph.get(curr).size()-1;i>=0;i--){
                // for(int elem:graph.get(curr)){
                int elem=graph.get(curr).get(i);
                indegree[elem]--;
                if(indegree[elem]==0) q.add(elem);
            }
        }

        for(int i=1;i<indegree.length;i++){
            if(indegree[i]!=0) return new int[0];
        }

        // below I am just converting my ans into compatible datatype form. No logic. Logic is completed above.
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}
