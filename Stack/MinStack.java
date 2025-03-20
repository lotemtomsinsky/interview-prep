package Stack;

import java.util.Stack;

// https://neetcode.io/problems/minimum-stack

public class MinStack{
    /*
     * notice that due to the signature of the pop function, if we want to keep the name but a different return
     * type than in the Stack class, we should use Composition rather than Inheritence 
     */
    private Stack<Integer> s;
    
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        s.push(Integer.valueOf(val));
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.size(); i++)
        {
            /*
             * since Stack extends the Vector class, we can get elements by index which allows us to iterate
             * over the entire stack element by element to find the minimum.
             */
            min = Math.min(min, s.get(i));
        }
        return min;
    }
}
