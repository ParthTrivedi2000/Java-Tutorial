package org.allTopics.BackTracking;

// Problem Link :- https://leetcode.com/problems/flood-fill/description/

// Problem Description :-
/*
You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of
the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image
starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel,
either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches
the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.



Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of
the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to
the image.


Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n

 */

public class BT12FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor==color) return image;
        floodFillBacktrack(image, sr,sc,oldColor,color);
        return image;
    }
    private void floodFillBacktrack(int[][] image, int startI, int startJ, int oldColor, int newColor){
        if(startI<0 || startI>=image.length || startJ<0 ||startJ>=image[0].length || image[startI][startJ] !=oldColor ) return;
        image[startI][startJ] = newColor;
        floodFillBacktrack(image,startI+1,startJ,oldColor,newColor);
        floodFillBacktrack(image,startI-1,startJ,oldColor,newColor);
        floodFillBacktrack(image,startI,startJ-1,oldColor,newColor);
        floodFillBacktrack(image,startI,startJ+1,oldColor,newColor);
    }

    // Conclusion :-
    /*
    Summary:
Flood Fill algorithm is a simple Recursive question.

1. In this problem, we need to change the old color of a cell, starting from (x,y), with the newColor given in the question.
We should only colour those cells which have the old colour and not any other cell. And we should always be within the
boundaries of the grid.
2. One edge case will be if newColor== oldColor. In that case, we don't need to change anything simply return the 2D
image vector
3. If not we will use recursion to color all the cells having oldColor with newColor.
4. Base cases will be pretty simple. We need to stay within the boundaries of the grid and we should change only those
grids who have oldColor.
if (i < 0 || i>=m || j<0 || j>=n || image[i][j] != oldColor)
return;
5. Now we need to move on 4 directions - up,down,left,right and ask recursion to color all the remaining cells having
color as oldColor.

Time Complexity: O(M*N) [ In worst case, we need to traverse the entire grid because all the cells might be having oldColor]
Space Complexity: O(M*N) [ In worst case we start from (0,0) and pain the entire grid with newColor. This causes the
recursive stack space equal to O(M*N)]

     */
}
