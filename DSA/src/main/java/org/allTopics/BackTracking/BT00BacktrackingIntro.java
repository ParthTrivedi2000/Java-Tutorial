package org.allTopics.BackTracking;

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

import java.util.*;

public class BT00BacktrackingIntro {
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
}
