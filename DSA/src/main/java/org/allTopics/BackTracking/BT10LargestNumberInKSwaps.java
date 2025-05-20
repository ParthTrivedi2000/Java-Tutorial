package org.allTopics.BackTracking;

// Problem Link :- https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1

// Problem Description :-
/*
Given a number K and string str of digits denoting a positive integer, build the largest number possible
by performing swap operations on the digits of str at most K times.
Example 1:
Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)
Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10
 */


// Intuition And Identification :-
/*
So by seeing the problem statement, from the 1st thought it looks like we can apply greedy algo.
means I can see, like string of numbers is given. I will find the max from the string and swap
it with the 1st char ryt... And what greedy algo says is like, mra long term goal h usko m aur jldi
short term m achieve krne ki try krta hu that is greedy algo. But here try to find the cases which
might be failed in greedy (Please always remember, whenever you want to apply greedy, always try to
think for finding the test cases which can fail if we apply greedy). So here we can think of one case
which includes duplicate integers in the string.
for exa:- 4577 --> for that suppose I am finding max i.e. 7 here and swapped with 4, bt here 1st 7
will be swapped with 4 bec somehow we will travese through string ans as soon as we encounter max we
will keep as it is ryt till the moment i got next max. so kehne ka mtlb yhi h ki 1st 7 will be swapped
with 1st 4. then again I will search for max and next 7 will be replaced with 5 so eventually
my answer will be 7745 which is incorrect ryt...correct ans will be 7754.

So means we can't apply greedy here. So now let's try to think for something else.

See here anyhow you are swapping only ryt. So me kya bol rha hu ki we can take the element and swap
it with each and every other elem in the string. so here I will be having choices to pick each elem
and have to decide the max elem from all the choices. So we can apply recursion (BackTracking).
 */


public class BT10LargestNumberInKSwaps {
    public static void main(String[] args) {}

    public static String findMaximumNum(String str, int k) {
        StringBuilder ans = new StringBuilder(str);
        rec(str.toCharArray(), k, ans, 0);
        return ans.toString();
    }
    public static void rec(char[] ip, int swaps, StringBuilder sb, int startIndex){
        // Base Condition:-
        if(swaps==0 || startIndex==ip.length-1){
            return;
        }

        int max = ip[startIndex];
        for(int i=startIndex;i<=ip.length-1;i++){
            if(ip[i]>max) max=ip[i];
        }

        // choices
        for(int i=startIndex+1;i<ip.length;i++){
            // Controlled recursion.
            if(ip[i]>ip[startIndex] && ip[i]==max){
                // just swap the numbers between i and sI.
                swap1(ip, i, startIndex);
                // as soon as you swap, pls store it as candidate answer, if you didn't
                // find another in future.
                if((String.valueOf(ip)).compareTo(sb.toString())>0){
                    sb.setLength(0); // clearing prev value from answer before storing new ans
                    sb.append(ip); // storing answer
                }
                rec(ip,swaps-1,sb, startIndex+1);
                swap1(ip,i,startIndex);
            }
        }
        // Making rec call in case of horizontal drifting of rec tree.
        // i.e. for the case like 721 --> none of the choice will be called ryt from above
        // loop as we were prooning (restricting) the tree to grow based on some condition
        // (which is also called as controlled rec ryt), so in that case as well, I want to
        // still make startIndex+1 and keep continue checking till ip string iteration
        // gets over.
        rec(ip,swaps,sb,startIndex+1);
    }
    public static void swap1(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }

    // T.C. of above code is :- no. of nodes of tree * work done of single node
    // =O(n!/(n-k)!) * O(N^2);
}
