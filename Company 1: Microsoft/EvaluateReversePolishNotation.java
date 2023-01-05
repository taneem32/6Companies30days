/*
Problem Statement: 

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9

Approach:

We traverse the tokens array one by one.
Here, we need to keep the track of most recent/left adjacent elements of operator(+,-,*,/). Hence, we use stack(LIFO) to store them.
Each time we receive an integer we store it and when we receive operator, we pop 2 elements and perform the required operation and store it once again in stack.
Finally the element present in the stack after entire traversal of array is the required answer.

*/


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if(tokens.length == 0)
        return 0;

        if(tokens.length == 1)
        return Integer.parseInt(tokens[0]);

        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("+") || tokens[i].equals("-") ||tokens[i].equals("*")||tokens[i].equals("/") )
            {
                int b = stack.pop();
                int a = stack.pop();

                switch(tokens[i])
                {
                    case "+": stack.push(a+b); break;
                    case "-": stack.push(a-b); break;
                    case "*": stack.push(a*b); break;
                    case "/": stack.push(a/b); break;
                }
                
            }
            
            else
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
