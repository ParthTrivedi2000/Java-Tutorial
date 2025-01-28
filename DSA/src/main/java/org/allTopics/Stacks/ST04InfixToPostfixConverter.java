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

// Please go through this solution for better understanding:-
// https://leetcode.com/discuss/interview-question/6113623/Infix-to-Postfix/


/*
 Thinking:-
1) Since if you see in the output, it is simply 1st characters (operands) are there and then operators.
2) So this time instead of dumping operands(chars) to the stack, we will extend the chars(operands) to the empty
output string and dumping the operators to the Stack.
3) With operators, there are 2 extra things. open and close brackets.
- open bracket ('(') will be simply pushed as other operators.
- while encountering close bracket (')'), now we have to get all the operators from the stack till the moment we
encounter the open bracket('(') and keep adding to the output string.
4) Now another imp thing is, while pushing any operator to the stack, we need to push it to the stack as per
the precedence. means higher precendented operator needs to be stayed at the top. So for examp, if you get any
low precedence operator like + or - and on the top of the stack * or / is rpesent then need to 1st pop it from
stack, append them to output string and need to push low precedented char to the stack.
5) At last all the remaining operators needs to be poped and appended to the output string except
open bracket('(').



// Approach :-
// Just do it in very simple way. just write down each and every statement in
// english, then we will implement it.

// 1) So if you encounter any Operand, then jst directly add it to postfix expr.
// 2) if you encounter '(' then we don't have to include it into postfix, and
// add it to stack.
// 3) if you encounter ')', then we don't need to add it to postfix, and
// instead adding into stack, start poping out everything from stack till '('
// encounters and add all those operators to the postfix expr.
// 4) if you encounter any operator, check for it's precedence from the elem
// present on the stack. If it has higher precedence then stack top elem, then
// add it to stack. Else if it has precedence less from stack top elem
// then need to pop the elems from stack. or if it equal then need to check the
// associativity of both the operators. if it's Left associativity then pop from
// stack. if it's right associativity, push into the stack.
// 5) After scanning of String from left to right is completed, then pop remaining
// all the operators from stack and append to the postfix exp.
 */

public class ST04InfixToPostfixConverter {
    public String solve(String A) {

        Stack<Character> st = new Stack<>();
        StringBuilder postFix = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(') {
                st.push(c);
            }
            else if (isOperator(c)) {
                if (c == ')') {
                    while (!st.isEmpty() && st.peek() != '(') {
                        // if (st.peek() != '(')
                        postFix.append(st.pop());
                    }
                    st.pop();  // removing '(' from the stack
                } else if (st.isEmpty()) {
                    st.push(c);
                } else {
                    // Addding high or equal precedence operators to c from the stack
                    while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                        postFix.append(st.pop());
                    }
                    st.push(c);
                }
            }
            else {
                postFix.append(c); // Adding operands in expr.
            }
        }

        while (!st.isEmpty()) { // Adding remaining operators from the stack
            postFix.append(st.pop());
        }
        return postFix.toString();
    }

    public static int precedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    public boolean isOperator(char c) {
        return c == ')' || c == '^' || c == '/' || c == '*' || c == '+' || c == '-';
    }
}
