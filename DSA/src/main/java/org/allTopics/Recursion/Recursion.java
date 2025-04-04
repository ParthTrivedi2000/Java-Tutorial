package org.allTopics.Recursion;

import java.util.*;

import static java.lang.Character.toUpperCase;

public class Recursion {
    public static void main(String[] args)  {
//        Stack<Integer> st = new Stack<>();
//        st.push(5);
//        st.push(6);
//        st.push(1);
//        st.push(0);
//        st.push(10);
//
//        System.out.println("Stack before sorting:");
//        for (Integer s : st) {
//            System.out.print(s + " ");
//        }
//
//        System.out.println("\nStack after sorting:");
//        Stack<Integer> sorted = sortStack(st);
//        for (Integer i : sorted) {
//            System.out.print(i + " ");
//        }

        // Input for stringSubset question :-
//        String input="abc";
//        String output="";
//        stringSubset(input,output);

//        recForPermutationCaseChange("","ab");
    }

/* Q - 3) Sort an array using recursion
 */
    // Solely by me only
    public ArrayList<Integer> sortArray(ArrayList<Integer> al){
        if(al.size()==1) return al;
        int lastElem = al.get(al.size()-1);
        al.remove(al.size()-1);
        sortArray(al);
        // putting back the removed element. /or  we can say this is the main induction step.
        return insertForSortingArray(al,lastElem);
    }

    public ArrayList<Integer> insertForSortingArray(ArrayList<Integer> al,int elem){
        if(al.size()==0 || elem>=al.get(al.size()-1)){
            al.add(elem);
            return al;
        }
        // Else during normal scenario [0,1,5], elem=2 --> then I have to remove last elem and call insert
        // method again with smaller i/p. And then put this removed element at the last again once insert()
        // method returns me the updated sorted list.
        int removedElem = al.get(al.size()-1);
        al.remove(al.size()-1);
        // See here notice below line very very very carefully, I made mistakes when revisited this question each time
        // see which elem we are inserting here. means here we are inserting elem passed in argument not the one which
        // we have removed in just above line.
        // And same concept is applicable whenever you wrote insert function for sorting purpose of any other DS.
        insertForSortingArray(al,elem);
        // And here finally we are inserting the removed element.
        al.add(removedElem);
        return al;
    }

/*
Q - 4) Sort a Stack using recursion
Problem Link :- https://www.geeksforgeeks.org/problems/sort-a-stack/1
 */
    public static Stack<Integer> sortStack(Stack<Integer> st){
        // Base Condition
        if(st.size()==1) return st;
        // poping out top element of stack and pass the remaining stack with smaller i/p to recursive
        // function again.
        int poppedElem = st.pop();
        //Hypothesis with smaller i/p
        sortStack(st);
        // Induction
        return insertFortSortingStack(st, poppedElem);
    }

    public static Stack<Integer> insertFortSortingStack(Stack<Integer> st,int elem){
        //Base Condition
        if(st.isEmpty() || elem>st.peek()){
            st.push(elem);
            return st;
        }
//        ArrayList<Integer> al = new ArrayList<>();
//        while(elem<st.peek()){
//            al.add(st.pop());
//        }
//        insert(st,)
        int removedElem = st.pop();
        //Hypothesis
        insertFortSortingStack(st,elem);
        //Induction
        st.push(removedElem);
        return st;
    }

/*
Delete middle element from stack
problem link:- https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
 */
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        // here k is, I am counting from the top of the stack not the bottom of stack.
        int k = (sizeOfStack%2==0)? sizeOfStack-(sizeOfStack/2)+1 : (sizeOfStack/2)+1;
        // calling recursive function
        delete(s,k);
    }
    public void delete(Stack<Integer> st, int k){
        // Base condition
        if(k==1){
            st.pop();
            return;
        }
        int poppedElem=st.pop();
        // Hypothesis
        delete(st,k-1);
        // Induction
        st.push(poppedElem);
        return;
    }

/*
Reversea stack using recursion
Problem Link :- https://www.geeksforgeeks.org/problems/reverse-a-stack/1

Problem Description :-
You are given a stack St. You have to reverse the stack using recursion.

Example 1:
Input:
St = {3,2,1,7,6}
Output:
{6,7,1,2,3}
Explanation:
Input stack after reversing will look like the stack in the output.
Example 2:
Input:
St = {4,3,9,6}
Output:
{6,9,3,4}
Explanation:
Input stack after reversing will look like the stack in the output.
Your Task:
You don't need to read input or print anything. Your task is to complete the function Reverse() which takes the
stack St as input and reverses the given stack.

Expected Time Complexity: O(N^2)
Expected Auxiliary Space: O(1)

Constraints:
1 <= size of the stack <= 10^4
-10^9 <= Each element of the stack <= 10^9
Sum of N over all test cases doesn't exceeds 10^6
Array may contain duplicate elements.
 */
    public static void reverse(Stack<Integer> s){
        // add your code here
        if(s.size()==1) return;
        int poppedElem = s.pop();
        reverse(s);
        insertForReversingStack(s,poppedElem);
        return;
    }
    public static void insertForReversingStack(Stack<Integer>st, int elem){
        if(st.isEmpty()){
            st.push(elem);
            return;
        }
        int removedElem = st.pop();
        insertForReversingStack(st,elem);
        st.push(removedElem);
        return;
    }


/*
Problem Link :- https://leetcode.com/problems/powx-n/
Problem Description :-
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
n is an integer.
Either x is not zero or n > 0.
-10^4 <= xn <= 10^4
 */

    public double myPow(double x, int n) {
        // Has to create long due to few of the long test cases.
        return rec(x,(long)n);
    }

    public double rec(double x, long n){
        if(n==0) return 1;
        else if(n==1) return x;

        double ans = 0.0;
        if(n<0){
            ans= 1.0/rec(x,(long)Math.abs(n));
            return ans;
        }
        ans = rec(x,n/2);
        if(n%2==0){
            return ans*ans;
        }
        return ans*ans*x;
    }



/* Kth Symbol in Grammer
Problem Link:- https://leetcode.com/problems/k-th-symbol-in-grammar/description/
Actually a very good problem

Problem Descreption:-
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at
the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.

Example 1:
Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0
Example 2:
Input: n = 2, k = 1
Output: 0
Explanation:
row 1: 0
row 2: 01
Example 3:
Input: n = 2, k = 2
Output: 1
Explanation:
row 1: 0
row 2: 01

Constraints:
1 <= n <= 30
1 <= k <= 2^(n - 1)
 */
    public int kthGrammar(int n, int k) {
        // Aprpaoch:- is to use recursion. How I came to know? See by reading the question
        // only you feel like something you are doing repeatedlly means for each time
        // when you go to new row, you are putting 01 for 0 for each 0 and 10 for 1 for
        // each 1. Accha then here again I don't have any choices + decision something so
        // we can't use recursive tree approach of recursion here. but anyhow recursion
        // will be applied ryt so let's think with IBH approach of recursion.

        // Hypothesis :-
        // solve(n,k) --> kth digit in nth row.
        // solve(?,?) -->
        // while designing hypothesis now here question how should I decreament n & k?
        // bec in all other previous easy problems, we are always doing n-1 and it
        // works. But here how to make input smaller?

        // n=1 --> 0
        // n=2 --> 0 1
        // n=3 --> 0 1 1 0
        // n=4 --> 0 1 1 0 1 0 0 1

        // So here Observation skills required to find the hypothesis and induction
        // step. Means here clearly you can observe like for any nth row, 1st half(i.e.
        // all the elements before mid) is as it is same as n-1th row. And next half
        // (i.e. after mid) elems are compliment bit of n-1th rows corresponding k value.

        // So my hypothesis should be, for 1st recursive call solve(n-1,k). but for
        // 2nd recursive call solve(n-1,k-mid).

        // And Induction should be, I have to 1st find the mid of each row and then
        // if k<=mid do 1st recursive call. if k>mid do 2nd recursive call.

        // Base condition is given in problem itself if you read it carefully. like if my
        // n==1 && k==1 then I have to return 0.

        // Final code:-
        if(n==1 && k==1) return 0;

        int mid = (int)(Math.pow(2,n-1)/2); //mid=len/2 and len is 2^n-1 for each row.

        if(k<=mid) return kthGrammar(n-1,k);
        else return kthGrammar(n-1,k-mid)==0?1:0;
        // And we are done!!!!!
    }

// Another version of very efficient code for above problem, so below is working for long values as well.
/*
public class Solution {
    public int solve(int A, Long B) {
        return rec(A,B);
    }

    public int rec(int A, Long B){
        if(A==1) return 0;
        int value = rec(A-1,B/2);
        if(B%2==0) return val;
        return 1 - val;
    }
}
 */


/*
Tower of Hanoi:-
Problem Link:- https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1

Problem Description :-
In the Tower of Hanoi puzzle, you are given n disks stacked in ascending order (smallest at the top) on the first of
three rods. The goal is to move all disks to the third rod following two rules: only one disk can be moved at a time, and
a disk can only be placed on top of a larger disk. Given the number of disks n and three rods labeled as from, to, and
aux (starting rod, target rod, and auxiliary rod, respectively),  returns the total number of moves needed to transfer
all disks from the starting rod to the target rod.

Examples:
Input: n = 2
Output: 3
Explanation: For n =2 , steps will be as follows in the example and total 3 steps will be taken.
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3
Input: n = 3
Output: 7
Explanation: For N=3 , steps will be as follows in the example and total 7 steps will be taken.
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3
Input: n = 0
Output: 0
Explanation: Total 0 steps will be taken.
Constraints:
0 <= n <= 16
 */
    // just enable below cnt initialization before running below code to declare it globally.
    long cnt = 0;
    public long toh(int n, int from, int to, int aux) {
        // Your code here
        // long cnt = 0;
        rec(n,from,to,aux);
        return cnt;

    }
    public void rec(int n, int source, int dest, int helper){
        cnt++;
        if(n==1){
            System.out.println("move disk "+ n + " from rod " + source +" to rod "+ dest );
            return;
        }
        rec(n-1,source,helper,dest);
        System.out.println("move disk "+ n + " from rod " + source +" to rod "+ dest );
        rec(n-1,helper,dest,source);
    }


// SubSets:-
/*
Problem Description:-
Given a set of distinct integers A, return all possible subsets.

NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The initial list is not necessarily sorted.

Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX

Input Format
First and only argument of input contains a single integer array A.

Output Format
Return a vector of vectors denoting the answer.

Example Input
Input 1:
A = [1]
Input 2:
A = [1, 2, 3]

Example Output
Output 1:
[
    []
    [1]
]
Output 2:
[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]

Example Explanation
Explanation 1:
 You can see that these are all possible subsets.
Explanation 2:
You can see that these are all possible subsets.
 */

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        res.add(new ArrayList<Integer>(seq));
        Collections.sort(A); // to make it in lexicographic order if not.

        // rf(A,0,seq,res);

        // Solely by me
        recFun(A,0,A.size(),seq,res);

        return res;
    }

    // recFun(ip,idx,n,seq,op);
    public void recFun(ArrayList<Integer> ip, int idx,int n, ArrayList<Integer>seq, ArrayList<ArrayList<Integer>> op){
        if(idx==n){
            // op.add(new ArrayList<>(seq)); // Just to match the given output order (i.e. to maintain the lexicography
            // order), we have to add the subset to output as soon as we form it. so just shifted this line just after
            // the formation of subset.
            return;
        }

        // Picking elem from ip and adding it to our DS.
        seq.add(ip.get(idx));
        op.add(new ArrayList<>(seq));
        //Making left recursive call
        recFun(ip,idx+1,n,seq,op);
        // Since we are sharing a single data structure between 2 recursive calls (here seq) to perform certain actions on
        // the same ds hence this step is needed so Removing item to get back to the original state before making
        // the right recursive call which is basically for not picking element
        seq.remove(seq.size()-1);

        // Finally making right recursive/Not picking call.
        recFun(ip,idx+1,n,seq,op); // see here again we passed idx+1 bec after completing above left recursive call, we
        // already returned back to the calling function hence i.e. variable idx has already revived it's state back.

    }


/*
Print all the subsequence of a String./ Print powersets of a String.
Link :- https://www.naukri.com/code360/problems/subsequences-of-string_985087?leftPanelTabValue=PROBLEM
 */
    public static void stringSubset(String input, String output){
        // base condition
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        // creating 2 outputs. one for pick and another for not pick.
        String output1 = output;
        String output2 = output + input.charAt(0);
        // reducing input to smaller input to pass in further recursive call.
        input = input.substring(1);
        //do recursive call
        stringSubset(input,output1);
        stringSubset(input,output2);
        return;
    }


/*
Q) Permutation with Spaces:-
Problem Link :- https://www.geeksforgeeks.org/problems/permutation-with-spaces3627/1
Problem Description :- Given a string s, you need to print all possible strings that can be made by
placing spaces (zero or one) in between them. The output should be printed in sorted increasing order
of strings.
Example :-
Input:
s = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation:
ABC
AB C
A BC
A B C
These are the possible combination of "ABC".
 */
    // Approach - 1:-
    /*
    public ArrayList<String> permutation(String s) {
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        String input = s.substring(1);
        String output = s.substring(0,1);
        // We are starting our recursive call from 1 index bec in o/p you can see like we don't need
        // to include any space at the left of 1st char of string and at the right of last char of
        // string. So we are keeping 1st char in our output string as it is without having any
        // choice of including any space or not. And from next char whenever I will include anything
        // in my output then I have to take care of choice (and hence recursion).
        recForPermutation(output,input,ans);
        return ans;
    }
    public static void recForPermutation(String output, String input, ArrayList<String> ans){
        if(input.length()==0){
            ans.add(output);
            return;
        }
        // Below you can see I have put output as 1st arg and input as 2nd arg. bec I am not
        // using any other variable in the code like op1 or op2 and then pass to the recursive call
        // instead I have directly do all the things in the recursive call only. So if you change
        // your input string before appending to the output string, then it will not give
        // appropriate output ryt so that's why i have 1st kept o/p and change it based on i/p
        // then include i/p.

        // Making 1st recursive call to pick next substring with space.
        recForPermutation(output+" "+ input.charAt(0),input.substring(1),ans);
        // Making 2nd recursive call to not include space.
        recForPermutation(output+ input.charAt(0), input.substring(1),ans);
        return;
    }

     */


    // Approach - 2:- Using StringBuilder :-
    public ArrayList<String> permutation(String s) {
        // Code Here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        op.append(s.charAt(0));
        rec(s,1,op,ans);
        return ans;
    }

    public void rec(String s, int idx, StringBuilder op, ArrayList<String> ans){
        // base case
        if(idx==s.length()){
            ans.add(op.toString());
            return;
        }

        // Adding current indexed elem with space
        op.append(" ");
        op.append(s.charAt(idx));
        // do recursive call
        rec(s,idx+1,op,ans);
        // when back from rec call
        // remove char with space, and add only current indexed elem without space
        op.deleteCharAt(op.length()-1);
        op.deleteCharAt(op.length()-1); // removing space
        // op.delete(op.length() - 2, op.length());
        op.append(s.charAt(idx)); // adding current elem without space
        // do recursive call
        rec(s,idx+1,op,ans);
        op.deleteCharAt(op.length() - 1); // Backtrack (remove the char)
    }

/*
Q) Permute a string by changing case:-
Problem Article :- https://www.geeksforgeeks.org/permute-string-changing-case/
Problem Statement :- Print all permutations of a string keeping the sequence but changing cases.
(Please make note, here we are assuming given string will be always in lowercase only).
Example :-
Input : ab
Output : AB Ab ab aB
 */
    // Approach - 1:-
    /*
    public static void recForPermutationCaseChange(String output, String input){
        if(input.length()==0){
            System.out.println(output);
            return;
        }
        recForPermutationCaseChange(output+input.charAt(0),input.substring(1));
        recForPermutationCaseChange(output+ toUpperCase(input.charAt(0)), input.substring(1));
        return;
    }

     */


    // Another Approach :- Using Stringbuilder :-
    // Function to generate permutations by changing cases
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        // Call the recursive helper function starting with an empty string
        generatePermutations(s, 0, new StringBuilder(), result);
        return result;
    }

    // Helper function to generate permutations recursively
    private static void generatePermutations(String s, int index, StringBuilder current, List<String> result) {
        // If we've processed all characters, add the current string to result
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        // Get the character at the current index
        char currentChar = s.charAt(index);

        // If it's a letter, we have two options: lower case or upper case
        // Option 1: Keep the character as it is
        current.append(Character.toLowerCase(currentChar));
        generatePermutations(s, index + 1, current, result);
        current.deleteCharAt(current.length() - 1); // Backtrack

        // Option 2: Change the character to the opposite case
        current.append(Character.toUpperCase(currentChar));
        generatePermutations(s, index + 1, current, result);
        current.deleteCharAt(current.length() - 1); // Backtrack

    }


/*
Q) Letter Case Permutation :-
Problem Link :- https://leetcode.com/problems/letter-case-permutation/description/
Problem Description :- Given a string s, you can transform every letter individually to be lowercase or
uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.
Example :-
Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]

Constraints:
1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.
 */
    // Approach - 1:-
    /*
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        rec("",s,ans);
        return ans;
    }
    public void rec(String output,String input, List<String> ans){
        if(input.length()==0){
            ans.add(output);
            return;
        }
        // op1 prepared to be passed for not pick call.
        String op1 = output + input.charAt(0);
        // And as op1 is prepared so we are making 1st recursive call for that as well.
        // we don't want to wait till we prepare op2 for next recuraive call.
        rec(op1,input.substring(1),ans);

        // Let's decide/ prepare op2 for pick call.
        // And here also remember you only need to make call which any char is not
        // digit. means else if you put this 2nd rec call after if else statement
        // then total o/p generate is 16 permutations. but we only want 4 permutations
        // which is happening just for the char is not digit. if any char is digit we
        // don't want any recursive call for that. that's why I have included it in
        // if else block. (you can just try and check by keeping this 2nd recusrsive call
        // outside if else. (Bec I have already checked it)).
        String op2 = "";
        if(input.charAt(0)>=97 && input.charAt(0)<=122){
            op2 = output + Character.toUpperCase(input.charAt(0));
            rec(op2,input.substring(1),ans);
        }
        else if(input.charAt(0)>=65 && input.charAt(0)<=90){
            op2 = output + Character.toLowerCase(input.charAt(0));
            rec(op2,input.substring(1),ans);
        }
        // else op2 = output + input.charAt(0);

        // rec(op1,input.substring(1),ans);
        // rec(op2,input.substring(1),ans);
        return;
    }

     */


    // Approach - 2:- Better approach:- Using StringBuilder
    /*
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        // Call the recursive helper function starting with an empty string
        generatePermutations(s, 0, new StringBuilder(), result);
        return result;

    }

    // Helper function to generate permutations recursively
    private static void generatePermutations(String s, int index, StringBuilder current, List<String> result) {
        // If we've processed all characters, add the current string to result
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        // Get the character at the current index
        char currentChar = s.charAt(index);

        // If it's a letter, we have two options: lower case or upper case
        if (Character.isLetter(currentChar)) {
            // Option 1: Keep the character as it is
            current.append(Character.toLowerCase(currentChar));
            generatePermutations(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack

            // Option 2: Change the character to the opposite case
            current.append(Character.toUpperCase(currentChar));
            generatePermutations(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        } else {
            // If it's not a letter, just add the character as is
            current.append(currentChar);
            generatePermutations(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

     */


/*
Generate all Parentheses II:-
Problem Link :- https://leetcode.com/problems/generate-parentheses/description/
Problem Description :- Given an integer A pairs of parentheses, write a function to generate all
combinations of well-formed parentheses of length 2*A.

Example :-
Input 1:
A = 3
Input 2:
A = 1
Output 1:
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:
[ "()" ]

Problem Constraints
1 <= A <= 10
 */
    public ArrayList<String> generateParenthesis(int A) {
        StringBuffer seq = new StringBuffer();
        ArrayList<String> ans = new ArrayList<>();
        rf(A,A,seq,ans);
        Collections.reverse(ans);
        return ans;
    }
    public void rf(int open, int close, StringBuffer seq, ArrayList<String> ans){
        // Base Condition
        if(open==0&&close==0){
            ans.add(seq.toString());
            return;
        }
        // If you put this condition 1st, then in above function from where main recursion function called
        // 1st time at that place you have to do collections.reverse before returning the ans.
        // Or else if you put another below 2nd condition as 1st, then no need to reverse the ArrayList.
        if(open<close){
            rf(open,close-1,seq.append(')'),ans);
            seq.delete(seq.length()-1,seq.length());
        }

        if(open>0){
            rf(open-1,close,seq.append('('),ans);
            seq.delete(seq.length()-1,seq.length());
        }
    }


/*
Print N-bit binary numbers having more 1s than 0s :-
Problem Link :- https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
Problem Description :- Given a positive integer n. Your task is to generate a string list of all n-bit
binary numbers where, for any prefix of the number, there are more or an equal number of 1's than 0's.
The numbers should be sorted in decreasing order of magnitude.
Example:-
Input:
n = 3
Output:
{"111", "110", "101"}
Explanation: Valid numbers are those where each prefix has more 1s than 0s.
111: all its prefixes (1, 11, and 111) have more 1s than 0s.
110: all its prefixes (1, 11, and 110) have more 1s than 0s.
101: all its prefixes (1, 10, and 101) have more 1s than 0s.
So, the output is "111, 110, 101".
Expected Time Complexity: O(|2n|)
Expected Auxiliary Space: O(2n)
Constraints:
1 <= n <= 15
 */
    public ArrayList<String> NBitBinary(int N) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        int ones = 0;
        int zeros=0;
        String op = "";
        rec(ones,zeros,N,op,ans);
        return ans;
    }
    public void rec(int ones, int zeros,int N, String op, ArrayList<String> ans){
        if(N==0){
            ans.add(op);
            return;
        }

        rec(ones+1,zeros,N-1,op+"1",ans);

        if(ones>zeros){
            rec(ones,zeros+1,N-1,op+"0",ans);
        }
        return;
    }


/*
Josephus Problem:-
Problem Link :- https://www.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1
GFG:- https://www.geeksforgeeks.org/problems/josephus-problem/1
leetcode:- https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
Problem Description :-
A total of n people are standing in a circle, and you are one of them playing a game. Starting from a person, k persons
will be counted in order along the circle, and the kth person will be killed. Then the next k persons will be counted
along the circle, and again the kth person will be killed. This cycle will continue until only a single person is left
in the circle.
If there are 5 people in the circle in the order A, B, C, D, and E, you will choose k=3. Starting from A, you will
count A, B and C. C will be the 3rd person and will be killed. Then you will continue counting from D, E and then A. A
will be third person and will be killed.
You will be given an array where the first element is the first person from whom the counting will start and the
subsequent order of the people. You want to be the last one standing. Determine the index at which you should stand
to survive the game. Return an integer denoting safe position.

Examples :
Input: n = 3, k = 2
Output: 3
Explanation: There are 3 persons so skipping 1 person i.e 1st person 2nd person will be killed. Thus the safe position
is 3.
Input: n = 5, k = 3
Output: 4
Explanation: There are 5 persons so skipping 2 person i.e 3rd person will be killed. Thus the safe position is 4.
Constraints:
1 <= n, k <= 20
 */
    public int josephus(int n, int k)
    {
        ArrayList<Integer> persons = new ArrayList<>();
        int ans=-1;
        for(int i=0;i<n;i++) persons.add(i+1);
        return recForJosephus(persons,k,0,ans);
    }
    public static int recForJosephus(ArrayList<Integer> al,int k,int index,int ans){
        // Base Condition:-
        if(al.size()==1) return al.get(0);

        index = (index+k-1)%al.size();
        al.remove(index);
        return recForJosephus(al,k,index,ans);
    }

    // Approach :-
    /*
    public int findTheWinner(int n, int k) {
        k = k-1;
        ArrayList<Integer> person = new ArrayList<>();
        for(int i=0;i<n;i++) person.add(i+1);
        return rec(person,k, 0);
    }

    private int rec(ArrayList<Integer>  arr, int k,int idx){
        if(arr.size()==1){
            return arr.get(0);
        }

        idx = (idx+k)%arr.size();
        arr.remove(idx);
        return rec(arr,k,idx);
    }
     */

}

// BackTracking :-
/* BackTracking:-
 - Backtracking is nothing but:- Controlled Recursion + Pass By Reference
 - When we talk about Recursion, so you can consider there are 3 child of Recursion.
 DP, BackTracking and Normal general Recursion.
 - So as we know like in Recursion generally we got answer on Leaf Nodes. In DP generally
 we got answers on Root Node. Similarly, in Backtracking we got answers on particular path.

 Identification of Backtracking needs to be applied or not? :-
 - Accha and one more thing if in any question it's given like provide All the Combinations
 or All the paths, or all the possible paths (from which rat can reach to maze, or all paths to solve
 sudoku etc etc) So wo sare cases me you should think of applying Backtracking.
 - Similarly if in any question it's given regarding to find optimal then you can think of
 applying DP over there.
 - And one more thing, like generally (pls note here I am not saying always this is the case bt generally)
 if any question is having large Choices/ Variable choices (As whatever problems we have done
 previously all those having only 2 choices ryt), then we can start thinking of applying BT.
 - One more imp point to identify BT is, constraint. Usually TC of backtracking is something like
 2^N or N^M (means exponential) or N!. So constraint given will be in 2 digit only like
 0<n<10 or 0<n<50 etc etc...means agr single digit diya h constraint m then for sure keep in mind to
 apply backtracking, but agr double digit diya h (like 30 or 50 or something) then it might happen ki
 usme koi optimisation lgegi.
 - And one thing is like since BT is child of recursion, so BT problem can also be done through
 normal recursion. but in that case you feel like this is not the correct way, or yha pe ku6 extra work
 ho rha h or ya to yha pe m complexity bdha rha hu aesa ku6...means BT ka wo problem recursion se
 krne pe wo feel hi aa jayegi ki nh nh isme BT needs to be applied. let's see in next question, we
 will try to solve using normal recursion 1st then using BT.

 Generalization of BackTracking :-
 - we usually keep return type as void of BT recursion function as we are using pass by reference, we will
 use some List of something to store or print.
 - BT is child of recursion so similar as recursion, we will be having base condition. But yes in normal
 recursion problem it is simple. but in BT problem it might become complex. So what we will do is always
 we will create a isSolved() function, if it returns true it means this path/ this combination/ this choice
 is valid and it is returning answer.
 if(isSolved()==true){
 List.add(answer);
 return;
 }
 But please remember this is for normal coding. but if you are sitting in interview, don't use such name
 of functions. instead use some sort of appropriate name of functions.

- Next thing is as we have discussed, since in BT no of choices are large. So now previously what we were
doing in normal recursion like we can have 2 function calls with 2 different inputs for 2 choices ryt. But
Now suppose I am having 8 choices. to m 8 bar function call thodi krne bethunga
funct(ip1)
func(ip2)
func(ip3)
   |
   |
instead we will use a loop to make function calls as due of large choices. for exa:-
for(int i=1-->10){
print(i)
}
(Note:- in recursive tree, function call is Nodes).

// Generalised template for BackTracking :- usually we will use the more or less same. Not everytime.
// it depends on the question and requirement.
void rec(passed by reference ip variable V){
    // 1)
    if(isSolved()==True){
        print();
        return;
    }
    // 2)
    // this choices list variable also should be passed by reference only.
    for(choice in choices){
        // 3) controlled recursion
        if(isValid()==true){
            //change the ip variable and then pass it to recursive call
            V = V + choice1;
            rec(changed ip variable V); // doing recursive call
            //revert/backtrack the changed ip variable V.
            V = V-choice1;
        }
    }
    return;
}

// BackTracking Questions :-

    //level-1 (easy)
1) Permutations of a String (we will do this 1st prob using both normal old recursion and then BT so we
came to know how BT reduces the complexity.
2) Largest Number in Kth Swap.
3) N digit number with digits in increasing order.
    // level-2(medium to hard)
4) Rat in a Maze
5) Word Break
6) Palindrome Partitioning
7) Combination Sum
8) Sudoku
9) N-Queens
10) Phone Letter Digits
// Below is Home work question:-
11) m coloring

- So just conclusion is, for any of the BT problem we mainly needs to apply mind in below 3 things
1) in writing isSolve() function
2) in writing isValid() function
3) to apply for loop properly on available choices.
And we are done.


Note :- Backtracking as a technique has broader scope than just that. Any situation where we might need to access a previous state
of a variable that keeps changing during the execution of the program requires backtracking.
 */

class BT {
/*
Permutations of Strings :-
 */
    // Code using Only Recursion not BackTracking:-
    public List<String> find_permutation_using_Only_Recursion(String S) {
        // Code here
        List<String> ans = new ArrayList<>();
        Set<Character> x = new HashSet<>();
        // Map<Character,Integer> x = new HashMap<>();
        String op = "";
        permutationRecursion(S, op, ans);
        Collections.sort(ans);
        return ans;
    }
    public void permutationRecursion(String ip, String op, List<String> ans) {
        if (ip.length() == 0) {
            ans.add(op);
            return;
        }
        // Map<Character,Integer> mp = new HashMap<>();
        Set<Character> st = new HashSet<>();
        // For each character of ip string I want to have rec call.
        for (int i = 0; i < ip.length(); i++) {
            // Reducing rec call, as we only want to make new rec call if char is new
            // bt how we came to know this char is not used yet for that we have used set here
            if (!st.contains(ip.charAt(i))) {
                // adding character to map to reduce the recursive call for repetitive char.
                // mp.put(ip.charAt(i),mp.getOrDefault(ip.charAt(i),0)+1);
                st.add(ip.charAt(i));
                String op1 = op + ip.charAt(i);
                String ip1 = ip.substring(0, i) + ip.substring(i + 1);
                // Now making rec call with new ip, op
                permutationRecursion(ip1, op1, ans);
            }
        }
        return;
    }

/*
So above code to find permutations is using recursion only. that is also we have used
controlled recursion. But we haven't use the pass by Reference while passing arg for op string.
If you see carefully, in the function itself, I am creating ip1 and op1 everytime and passing it
further which is the pass by value. And in BackTracking (Controlled Rec + Passed By Reference)  as we
have discussed, like we need to pass by ref in arg. And then once we will be done with our work and once
got the answer, we will revert back the changes whatever changes we have done on the ip (i mean we are not
creating ip everytime in this case, instead we were using single same ip for further calls, so once work
is done, then it's our responsibility to get ip in the correct state ryt as we will be using same ip for
other rec calls so.
 */
    public List<String> find_permutation(String S) {
        // Code here
        // Approach :- use backtracking
        StringBuilder sb = new StringBuilder(S);
        List<String> ans = new ArrayList<>();
        int startIndex = 0; // this index we need to pass as reference as it will be
        // eventually used for base condition, to stop recursion.
        rec(S.toCharArray(),startIndex, ans);

        Collections.sort(ans);
        return ans;
    }
    public void rec(char[] ip, int index, List<String> ans){
        if(index==ip.length-1){
            ans.add(String.valueOf(ip));
            return;
        }
        Set<Character> st = new HashSet<>();
        for(int i=index;i<ip.length;i++){
            // to have controlled rec, I have to restrict branch for which char is
            // duplicated.
            if(!st.contains(ip[i])){
                st.add(ip[i]);
                swap(ip,index,i);
                rec(ip,index+1,ans);
                swap(ip,index,i);
            }
        }
    }
    public void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }

/* Largest Number in K swaps :-
Problem Link :- https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1
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
/* Intution And Identification :-
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
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        //code here.
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

/*
Q) N Digit numbers with digits in increasing order :-
Problem Link :- https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
Problem Description :- Given an integer n, print all the n digit numbers in increasing order, such that their
digits are in strictly increasing order(from left to right).
Example:-
Input:
Input:
n = 2
Output:
12 13 14 15 16 17 18 19 23....79 89
Explanation:
For n = 2, the correct sequence is
12 13 14 15 16 17 18 19 23 and so on
up to 89. Single digit numbers are considered to be
strictly increasing order.
Expected Time Complexity: O(9^n)
Expected Auxiliary Space: O(n)
Constraints:
1 <= n <= 9
 */
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(n == 1){
            for(int i=0; i<=9; i++) ans.add(i);
            return ans;
        }
        recForIncreasingNumbers(ans, temp, n, 0);
        return ans;
    }
    public static void recForIncreasingNumbers(ArrayList<Integer> finalList, ArrayList<Integer> temp, int n, int start){
        if(n == 0){
            int ans = 0;
            for(int i=0; i<temp.size(); i++) ans = ans * 10 + temp.get(i);
            finalList.add(ans);
        }
        for(int i = start + 1; i<=9; i++){
            temp.add(i);
            recForIncreasingNumbers(finalList, temp, n - 1, i);
            temp.remove(temp.size() - 1);
        }
    }

}
