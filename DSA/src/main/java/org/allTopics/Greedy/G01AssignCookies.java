package org.allTopics.Greedy;

// Problem Link :- https://leetcode.com/problems/assign-cookies/description/
// Similar problem :- https://leetcode.com/problems/maximum-matching-of-players-with-trainers

/*
Problem Statement :-

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one
cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and
each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be
content. Your goal is to maximize the number of your content children and output the maximum number.

Example 1:
Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:
Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
You have 3 cookies and their sizes are big enough to gratify all of the children,
You need to output 2.

Constraints:

1 <= g.length <= 3 * 10^4
0 <= s.length <= 3 * 10^4
1 <= g[i], s[j] <= 2^31 - 1

Note: This question is the same as 2410: Maximum Matching of Players With Trainers.

 */

import java.util.Arrays;

public class G01AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Approach:-
        // So since we want to distribute cookies such that, children are maximised.
        // So suppose I am having cookies array as s and greediness of child array as g.
        // Now for distributing the cookies, think like I want to give cookie to child such
        // that just his greediness is fulfilled. So for that greedily I will try to give cookie as much
        // close to his greediness. for example, if child has greediness of 3, then and I can have
        // option to give 1,5,7,3,4 then I instead of giving random from it, I will try to give
        // 3 so that other higher valued cookies can be utilised for next children whom might
        // have more greediness.

        // So to distribute such as maximum children fulfilled, I need to sort the child greediness
        // array and also need to sort the cookie array so that I can directly say that ki accha
        // I should give this cookie to this through comparison between greediness of child and
        // cookie value.

        // Approach is to use 2 pointers keeping each on starting idx of each array after sorting
        // the array.

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0; // pointer representing the g array
        int j=0; // pointer representing the s array
        while(i<g.length && j<s.length){
            // if greediness is just equal or lesser the cookie value, then I can feed
            // else I have to move ahead j to get bigger cookie.
            if(g[i]<=s[j]){
                i++;
                j++;
            }
            else j++;
        }
        // wherever my i is there/or stopped, utne children were feeded, so return it.
        return i;
    }
}
