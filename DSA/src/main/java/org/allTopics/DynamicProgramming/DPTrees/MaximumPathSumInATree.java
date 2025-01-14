package org.allTopics.DynamicProgramming.DPTrees;

// Problem Statement :- https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

/*
Problem Description :-

 */

public class MaximumPathSumInATree {
    int globalBestAnswer=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int ans = maxSum(root);
        return globalBestAnswer;
    }

    int maxSum(TreeNode node){
        // sanity check:-
        // if my root itself is wrong or here null,
        if(node==null) return 0;

        // base case:- if I reached to my leaf node, then I have to return the root value
        if(node.left == null && node.right == null){
            globalBestAnswer = Math.max(globalBestAnswer,node.val);
            return node.val<0?0:node.val; //Math.max(0,node.val);
        }


        // recursive case:-
        // there can be 5 possibilities
        // 1) maxSum(node.left)
        // 2) maxSum(node.right)
        // 3) strightPath sum from Left side
        // 4) strightPath sum from right side
        // 5) Stright path sum from left side + right side + root itself.

        // but return value should be max of(option 3,4) only.
        // but final answer i.e. globalBestAnswer would be max of all of the 5 options

        int LeftSide = maxSum(node.left); // this is the eventually we have created rec function in such a way that it will return always straight path sum only
        int RightSide = maxSum(node.right); // same as above

        // but best answer to be return would be max of these 2
        int maxi = Math.max(Math.max(LeftSide+node.val , RightSide+node.val), node.val);

        // Total overall best answer is would be max of all the 5 options ryt.
        int oveallBestAnswer = Math.max(maxi, LeftSide+RightSide+node.val);

        // updating final global answer
        globalBestAnswer = Math.max(globalBestAnswer,oveallBestAnswer);

        // but as we discussed return answer should be different ryt which should not
        // consider the bend path so
        return maxi;
    }
}
