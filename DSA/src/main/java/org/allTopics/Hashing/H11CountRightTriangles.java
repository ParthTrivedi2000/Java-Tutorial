package org.allTopics.Hashing;

// Problem Link :- https://www.scaler.com/academy/mentee-dashboard/class/28500/assignment/problems/4719?navref=cl_tt_lst_nm

/*
Problem Description :-

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique
point (x, y) in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a
right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).

Problem Constraints
1 <= N <= 10^5
0 <= A[i], B[i] <= 10^9

Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).

Example Input
Input 1:
 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:
 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]

Example Output
Output 1:
 1
Output 2:
 6

Example Explanation
Explanation 1:
 All three points make a right angled triangle. So return 1.
Explanation 2:
 6 triplets which make a right angled triangle are:    (1, 1), (1, 2), (2, 1)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)

 */

import java.util.HashMap;
import java.util.Map;

public class H11CountRightTriangles {
    // Bruteforce Approach :- TC:- O(N^3)
    /*
    So we need to find weather right angled triangle formed between 3 points or not. so suppose we are having points(x,y) in
    the array form as i/p:- for exa:- [(3,3),(6,3),(9,3),(2,3),(5,5),(5,10),(3,5),(9,5)].
    So concept says that for any 3 points, if 2 of them have same x coordinates and remaining 1 is having same y
    coordinates with any of them, then there is triangle possible between these 3 points. And common point between them
    is where right angle created. And 2 sides are parallel with x and y axis.

    So for implementation of bruteforce, we will pick each 3 points from array and checking that right angled triangle
    is possible or not.

    considering i/p as collection of points (x,y) object.

    Pseudo Code:-

    for(int i=0;i<A.length;i++){
        for(int j=i+1;j<A.length;j++){
            for(int k=j+1;k<A.length;k++){
                if((A[i].x==A[j].x) and (A[j].y==A[k].y)) || (A[j].x==A[k].x) and (A[k].y==A[i].y)) || (A[k].x==A[i].x) and (A[i].y==A[j].y)){
                    triangle++;
                }
            }
        }
    }

     */

    // Optimised Approach:- TC:- O(N), SC:- O(N)
    /*
    So in above bruteforce approach what we did is, we were taking 3 points and check weather they are able to create the
    right angled triangle or not. but in optimised approach we will not take 3 points else complexity stays same ryt to choose
    3 points from array. but we want to improve it. so this problem can further be improved by choosing 2 points and checking
    for right angled triangle which costs us of TC:- O(N^2).
    But we want to optimise it further. so concept is we will pick each single point everytime, and consider like right
    angle is created at that point, then property says, ki that point should share same x coordinate with 1 point and share
    same y coordinate with another point. so if such points exists then we can say ki yes current point is actually creating
    right angle. And jitne points milenge on same x axis and y axis utne right angled triangle can be possible for that
    particular point.
    So we need to have 2 hashmap to store the x coordinates ans y coordinates. See below code for more understanding.
     */
    public int solve(int[] A, int[] B) {
        // need to create map for x-axis points and y-axis points
        Map<Integer,Integer> mpX = new HashMap<>(); // Storing points on X axis.
        Map<Integer,Integer> mpY = new HashMap<>(); // Storing points on Y axis.

        for(int i=0;i<A.length;i++){
            int x = A[i];
            int y = B[i];
            mpX.put(x,mpX.getOrDefault(x,0)+1);
            mpY.put(y,mpY.getOrDefault(y,0)+1);
        }

        // So now mpX has values and mpY also has the values
        int triangles=0;
        for(int i=0;i<A.length;i++){
            // suppose right angle is there on this current i,j point. So finding corresponding points on x and y axis
            // and multiply it so getting ans by considering right angle at this current point(i,j)
            triangles += ((mpX.get(A[i])-1) * (mpY.get(B[i])-1));
        }
        return triangles;


        // // Not working Bruteforce:-
        // // picking 3 points i,j,k and checking weather those 3 points are forming any right angled triangle or not.
        // int triangle=0;
        // for(int i=0;i<A.length;i++){
        //     for(int j=i+1;j<A.length;j++){
        //         for(int k=j+1;k<A.length;k++){
        //             if((A[i]==A[j] && B[j]==B[k])||(A[j]==A[k] && B[k]==B[i])||(A[k]==A[i] && B[i]==B[j])) triangle++;
        //         }
        //     }
        // }
        // return triangle;
    }

}
