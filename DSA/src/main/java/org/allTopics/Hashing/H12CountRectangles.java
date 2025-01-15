package org.allTopics.Hashing;

// Problem Link :- https://www.scaler.com/academy/mentee-dashboard/class/28500/assignment/problems/4759/?navref=cl_pb_nv_tb

/*
Problem Description :-
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique
point (x, y) in a 2-D Cartesian plane.
Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k])
and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered quadruplets that form a rectangle.

Example Input
Input 1:
 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:
 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]

Example Output
Output 1:
 1
Output 2:
 3

 */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class H11CountRectangles {

    // Bruteforce :-
    /*
    This problem is similar as prev problem of counting right angled triangles. here we need to find the count of rectangles.
    so as a bruteforce approach again we can pick no of points to formulate rectangle (i.e. 4 points).
    Hence to pick 4 points everytime from array of points, and then inside we need to check the property.
    Property/Concept says, if you know info about 2 diagonal points, then you can find other 2 diagonal points from those 2.
    for example:- 2 diagonal points are A(a,b) and D(c,d) --> then other 2 diagonal elems must be B(c,b) and C(a,d).
    this property we can check inside 4 loops. SO total TC of bruteforce might be O(N^4).
     */

    // Optimised Approach:-
    /*
    So since above we are picking 4 points hence having TC would be O(N^4). Now if picking 3 points then O(N^3), if
    2 elems then O(N^2). Here please note that, if you think by picking only single element, then it won't possible
    to find the coordinates of other 3 from that single point.
    So at starting we need to have info about 2 points, and from that we can find other 2 elems means that is how
    we can check the condition and can confirm weather this 4 points can formulate the rectangle.
     */

    // For better understanding, go through this article:-
    // https://www.geeksforgeeks.org/find-number-of-rectangles-that-can-be-formed-from-a-given-set-of-coordinates/

    class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int countRectangles(int[] A, int[] B) {
        Set<Pair> hs = new HashSet<>();
        // Adding points to the HashSet
        for(int i=0;i<A.length;i++){
            hs.add(new Pair(A[i],B[i]));
        }

        // from the points, checking the conditions for rectangle
        int rectangle=0;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                // Check if points i((x,y)=(A[i],B[i])) and j((x,y)=(A[j],B[j])) can form a diagonal
                if(A[i] != A[j] && B[i] != B[j]) {
                    Pair assumedP3 = new Pair(A[i], B[j]);
                    Pair assumedP4 = new Pair(A[j], B[i]);
                    if(hs.contains(assumedP3) && hs.contains(assumedP4)) {
                        rectangle++;
                    }
                }
            }
        }
        return rectangle/2; // Each rectangle is counted twice
    }


    // Solution by Scaler:-
    public int solve(int[] a, int[] b) {
        int n = a.length;
        HashMap<Integer, HashSet<Integer>> mpx = new HashMap<>();
        HashSet<Integer> h;
        // stores all the points
        for (int i = 0; i < n; i++) {
            if (mpx.containsKey(a[i]))
                h = mpx.get(a[i]);
            else
                h = new HashSet<>();
            h.add(b[i]);
            mpx.put(a[i], h);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // checks if there exists a rectange such that the i-th and
                // j-th points are the ends of a diagonal
                if (a[i] == a[j] || b[i] == b[j])
                    continue;
                if (mpx.get(a[i]).contains(b[j]) && mpx.get(a[j]).contains(b[i]))
                    ans++;
            }
        }
        return ans >> 1;
    }
}
