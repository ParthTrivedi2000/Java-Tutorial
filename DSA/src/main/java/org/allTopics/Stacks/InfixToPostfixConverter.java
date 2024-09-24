package org.allTopics.Stacks;

/*
Why postfix representation of the expression?
The compiler scans the expression either from left to right or from right to left.
Consider the expression: a + b * c + d

The compiler first scans the expression to evaluate the expression b * c, then again scans the expression to
add a to it.
The result is then added to d after another scan.
The repeated scanning makes it very inefficient. Infix expressions are easily readable and solvable by humans whereas
the computer cannot differentiate the operators and parenthesis easily so, it is better to convert the expression to
postfix(or prefix) form before evaluation.

The corresponding expression in postfix form is abc*+d+. The postfix expressions can be evaluated easily using a stack.
 */


// Problem Link:- https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620

/* Problem Description:-
Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right
associativity of ^.
Example 1:
Input: str = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
Explanation:
After converting the infix expression
into postfix expression, the resultant
expression will be abcd^e-fgh*+^*+i-
Example 2:
Input: str = "A*(B+C)/D"
Output: ABC+*D/
Explanation:
After converting the infix expression
into postfix expression, the resultant
expression will be ABC+*D/

Expected Time Complexity: O(|str|).
Expected Auxiliary Space: O(|str|).

Constraints:
1 ≤ |str| ≤ 10^5
 */

public class InfixToPostfixConverter {

}
