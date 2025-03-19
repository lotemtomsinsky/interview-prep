package Stack;

import java.util.Stack;

// https://neetcode.io/problems/evaluate-reverse-polish-notation

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        String operands = "+-*/";
        Stack<Integer> stack = new Stack<>();

        for (String t : tokens)
        {
            // if it's not an operand, push it onto the stack
            if (!operands.contains(t))
            {
                stack.push(Integer.valueOf(t));
            }
            else
            {
                // if the stack is empty, we have nothing left to process
                if (stack.isEmpty())
                {
                    break;
                }

                /*
                 * val 2 represents the accumulated evaluation so far, 1 is what was recently added. 
                 * only diff in initial case where they're the first two numbers we add to the stack
                */ 
                int val1 = stack.pop();
                int val2 = stack.pop();

                // push the evaluated result back onto the stack. use .equals because comparing strings
                if (t.equals("+"))
                {
                    stack.push(val2 + val1);
                }
                else if (t.equals("-"))
                {
                    stack.push(val2 - val1);
                }
                else if (t.equals("*"))
                {
                    stack.push(val2 * val1);
                }
                else if (t.equals("/"))
                {
                    stack.push(val2 / val1);
                }
            }
        }

        // the bottom most element of the stack is the result
        return stack.get(0);
    }

    public static void main(String[] args)
    {
        //String[] tokens = {"1","2","+","3","*","4","-"}; // expect 5
        String[] tokens = {"2","1","+","3","*"}; //expect 9]
        System.out.println(evalRPN(tokens));
    }
}
