package org.allTopics.Stacks;

/*
Evaluate an expression represented by a String. The expression can contain parentheses, you can assume parentheses
are well-matched. For simplicity, you can assume only binary operations allowed are +, -, *, and /. Arithmetic
Expressions can be written in one of three forms:

Infix Notation: Operators are written between the operands they operate on, e.g. 3 + 4.
Prefix Notation: Operators are written before the operands, e.g + 3 4
Postfix Notation: Operators are written after operands.

Infix expression: The expression of the form “a operator b” (a + b) i.e., when an operator is in-between every
pair of operands.
Postfix expression: The expression of the form “a b operator” (ab+) i.e., When every pair of operands is followed
by an operator.

Infix Expressions are harder for Computers to evaluate because of the additional work needed to decide precedence.
Infix notation is how expressions are written and recognized by humans and, generally, input to programs. Given that
they are harder to evaluate, they are generally converted to one of the two remaining forms. A very well known
algorithm for converting an infix notation to a postfix notation is Shunting Yard Algorithm by Edgar Dijkstra.

This algorithm takes as input an Infix Expression and produces a queue that has this expression converted to postfix
notation. The same algorithm can be modified so that it outputs the result of the evaluation of expression instead of
a queue. The trick is using two stacks instead of one, one for operands, and one for operators.
 */

// Problem Link:- https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735
//Below is example of Evaluation of postfix expression
/*
Given string S representing a postfix expression, the task is to evaluate the expression and find the final value.
Operators will only include the basic arithmetic operators like *, /, + and -.

Example 1:
Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression,
we have -4 as result.
Example 2:
Input: S = "123+*8-"
Output: -3
Explanation:
After solving the given postfix
expression, we have -3 as result.

Expected Time Complexity: O(|S|)
Expected Auixilliary Space: O(|S|)


Constraints:
1 ≤ |S| ≤ 10^5

0 ≤ |Si|≤ 9 (And given operators)
 */

import java.util.Stack;

public class EvaluateExpression {
    public static int evaluatePostFix(String S)
    {
        // Approach:-
        // need to start traversing the char array
        // if char is operator, it needs to be pushed to the stack. if any operand is there, we need to pop 2 times and
        // push the answer.

        Stack<Integer> st = new Stack<>();
        // String ch = "";
        int elem1 = 0;int elem2=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='*' || S.charAt(i)=='+'|| S.charAt(i)=='-' || S.charAt(i)=='/'){
                if(!st.isEmpty()) elem1 = st.pop();
                if(!st.isEmpty()) elem2 = st.pop();
                if(S.charAt(i)=='*') st.push(elem2 * elem1);
                else if(S.charAt(i)=='/') st.push(elem2 / elem1);
                else if(S.charAt(i)=='+') st.push(elem2 + elem1);
                else if(S.charAt(i)=='-') st.push(elem2 - elem1);
            }
            else{
                st.push(Character.getNumericValue(S.charAt(i)));
            }
        }
        return st.peek();
    }
}

// Similarly if it was asked to evaluate prefix expression, we just need to run main for loop from last and everything
// else remain same as it is.
/*
Evaluating Prefix Expressions:
Prefix notation, also known as Polish Notation, is a mathematical notation where every operator follows all of its
operands. Unlike infix notation, prefix notation eliminates the need for parentheses and defines a clear order of
operations. Using stacks, we can efficiently evaluate prefix expressions, making it a fundamental concept in computer
science and mathematics.

Consider the prefix expression: + * 3 4 2
 */

// For this also we need to write same code as postfix expression evaluation logic. And need to apply the same logic.
/*
Evaluating Infix Expressions:
Infix notation is the standard mathematical notation where operators are placed between operands, and parentheses are
used to indicate the order of operations. Mastering the evaluation of infix expressions is crucial in computer science
and mathematics. By utilizing stacks, we can elegantly handle infix expressions, making complex calculations more
manageable and efficient.
Consider the infix expression: (3 * 4) + 2.
 */
