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

     */

    /*
    So below we have used DFS to detect the cycle in the graph. for example, graph is:- 0 ------ 1 --------- 2
    Now in above case, for example, we are considering only visited logic. so with that logic suppose from 1st node
    we have started, so we marked node 0 as visited & got to node 1. then for node 1 we are having 0 & 2 as child. now
    we can see 0th is marked visited, but cycle is not there between them ryt. so means with only visited logic is
    not enough here to detect the cycle. we need to check something else as well.

    see here we can see that 0 is parent node for 1 ryt. so when we reach to node 1 & check it's children list,
    at that time if we got 0 as children, then we won't do anything for it. i.e. if child==parentNode, then we should
    skip it & move ahead with next children. So here simply everytime, with each node, we have to pass the parentNode
    as well to the DFS.

    And if we reach to any other node except parentNode which is already marked, then we can say that yes, we are
    reaching here 2nd time hence there is a cycle, so we can return true directly incase visited of that child is true.

    See below code for more understanding.
     */

    /*
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
    Logic for BFS is as is of DFS. only thing we have to change is logic of BFS need to be included instead
    of DFS. so in BFS, we are using queue to maintain the ordering. So here also we need to push the startNode.
    Then we can start main logic. it means while queue is not empty then, when we popped element, we need to check
    it's children ryt. now if child is not visited, then there is no issue, so we can mark it as visited & push to
    the queue. Now if it's not visited, there we are scaring it might happen there is cycle ryt. but if that visited
    child is parentNode, then there is no cycle ryt (as discussed above in DFS approach). And at last, if neither of
    those conditions true then we can return false by saying there is no cycle in the graph.

    One more thing to note here is, here how to consider parent for each node? so we haev to create the Pair class & add
    pair to the queue. simple!!!


    Conclusion (applicable to both DFS or BFS) :-
    - if child node != visited --> we are safe
    - if child is visited --> there might be cycle
                          --> but if that visitedNode is parent --> then we are safe, there is no cycle.
    - else there is cycle.

     */

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
