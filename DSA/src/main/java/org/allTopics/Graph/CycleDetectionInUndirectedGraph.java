package org.allTopics.Graph;

// Problem Link :- https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

/*
Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or
not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex
is connected.

Examples:
Input: V = 5, E = 5
adj = [[1], [0, 2, 4], [1, 3], [2, 4], [1, 3]]
Output: 1
Explanation:
1->2->3->4->1 is a cycle.

Input: V = 4, E = 2
adj = [[], [2], [1, 3], [2]]
Output: 0
Explanation:
No cycle in the graph.

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)

Constraints:
1 ≤ V, E ≤ 10^5

 */

// Concept :- for any node, if Visited == true and if it's not parent --> yes cycle is there else no

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class CycleDetectionInUndirectedGraph {

    // Approach - 1:- Using DFS
    /*
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if(visited[i]==false && DFS(adj,visited,i,-1)) return true;
        }
        return false;
    }

    boolean DFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startNode, int parentNode) {
        visited[startNode] = true;

        for (int child : graph.get(startNode)) {

            if (child == parentNode) continue;
            if (visited[child] == true) return true;
            if (DFS(graph, visited, child, startNode) == true) return true;
        }
        return false;
    }
    */



    // Approach - Using BFS
    /*
    class Pair{
        int curr;
        int parent;
        Pair(int a, int b){
            curr = a;
            parent = b;
        }
    }
     */

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if(visited[i]==false && BFS(adj,visited,i)) return true;
        }

        return false;
    }

    boolean BFS(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startNode){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode,-1));
        visited[startNode] = true;

        while(!q.isEmpty()){
            Pair temp = q.poll();
            int currentNode = temp.x;
            int  parentNode = temp.y;
            for(int child: graph.get(currentNode)){
                if(visited[child]==false){
                    q.add(new Pair(child,currentNode));
                    visited[child]=true;
                }
                else if(child != parentNode) return true;
            }
        }
        return false;
    }
}
