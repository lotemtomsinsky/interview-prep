package Stack;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/generate-parentheses


public class GenerateParentheses {

    /*
     * here we use StringBuilder to emulate a stack.
     * the general idea of backtracking is: 1. make a choice 2. explore the choice recusively 3. undo the choice, aka backtrack
     * in this case explicitly it means: 1. choose a parenthese to add to the string 2. explore by calling backtrack with updated open or close
     * values 3. remove the last char added to the string to undo the choice 
     */
    private static void backtrack(int open, int closed, int n, List<String> result, StringBuilder stack)
    {
        // this means we have a matching amount of open & closed and its the same as n, making it a valid result
        if (open == closed && open == n){
            result.add(stack.toString());
            return;
        }

        // this means we still have space for another opening bracket
        if (open < n)
        {
            stack.append('(');
            backtrack(open + 1, closed, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        // this means we still have space for another closing bracket. We only want to add a closing one if there's an open one 
        if (closed < open)
        {
            stack.append(')');
            backtrack(open, closed + 1, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
       StringBuilder stack = new StringBuilder();
       
       // modifies the passed list on the spot so we don't need to define a return type for this function
       backtrack(0, 0, n, result, stack);
       return result;
    }

    public static void main(String[] args)
    {
        List<String> result = generateParenthesis(1);
        for (String r : result)
        {
            System.out.println(r);
        }
    }
}
