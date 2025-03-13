package Stack;

import java.util.HashMap;
import java.util.Stack;

// https://neetcode.io/problems/validate-parentheses

public class ValidParentheses {
    public static boolean isValid(String s) {
        HashMap<Character, Character> mapping = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        // make a mapping of open to closed parentheses
        mapping.put('{', '}');
        mapping.put('(', ')');
        mapping.put('[', ']');

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            //  if the char is a key, this means it's an open bracket, push it to the stack
            if (mapping.containsKey(c))
            {
                stack.push(c);
            }
            else
            {
                // if we're not all the way through the string yet and the stack is empty -> more closing than opening
                if (stack.isEmpty())
                {
                    return false;
                }

                // find the last opening bracket we saw
                char lastSeen = stack.peek();
                // get what the associated closing bracket should be 
                char associatedBracket = mapping.get(lastSeen);
                if (associatedBracket == c){
                    stack.pop(); // we can remove this opening bracket form consideration
                }
                else
                {
                    return false;
                }
            }
        }

        // if the stack is empty, then it's valid otherwise there's more opening than closing
        return stack.empty() ? true : false;
    }

    public static void main(String[] args)
    {
        String s = "]";
        System.out.println(isValid(s));
    }

}
