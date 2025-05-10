package org.allTopics.Graph;

// Problem Statement:- https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

/*
Problem Description :-
Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there
is a edge directed from node B[i][0] to node B[i][1].
Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:
The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.

Problem Constraints
2 <= A <= 10^5
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed
from node B[i][0] to node B[i][1].

Output Format
Return 1 if cycle is present else return 0.

Example Input
Input 1:
 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]
Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:
 The given graph doesn't contain any cycle.

 */

// Concept:- if node is visited==true and also present in the path i.e. path[node]==true, then --> yes there is cycle

import java.util.ArrayList;

public class CycleDetectionInDirectedGraph {
    public boolean isCyclic(int A, int[][] B) {

        // Graph creation Step
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=A;i++) graph.add(new ArrayList<>());

        for(int i=0;i<B.length;i++){
            int u = B[i][0];
            int v = B[i][1];
            graph.get(u).add(v);
        }

        // graph has been created.

        // next step:- cycling logic started
        boolean[] visited = new boolean[A+1];
        boolean[] path = new boolean[A+1]; // this represents nodes present in the recursive stack trace path during any DFS call.
        boolean cycle=false;
        for(int i=0;i<=A;i++){
            if(visited[i]==false) cycle = DFS(graph,i,visited,path);

            if(cycle) return true;
        }
        return false;

    }

    /*
    If child node is not visited --> then simply we can call the DFS with that child. And if that DFS call returns
    true, we can return true i.e. cycle is there. Now if node is visited, and it present in the path as well, then
    we can return true bec it is already visited & also part of current recursive stack trace so.
    And if either of those condition is not true, then we can return the false. but just before returning the false from
    DFS function, since we marked node as true in path array, now we are ending current rec trace path for current
    DFS call, so before ending it, we need to mark it as false in the path array.
     */

    boolean DFS(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited, boolean[] path){
        visited[start] = true;
        path[start] = true;

        for(int child: graph.get(start)){
            if(path[child]==true) return true;
            else if (visited[child]==false && DFS(graph,child,visited,path)) return true;
        }
        path[start] = false;
        return false;
    }
}
