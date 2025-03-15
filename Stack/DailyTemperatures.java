package Stack;

import java.util.Stack;

// https://neetcode.io/problems/daily-temperatures

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();  // stack to store indices

        //TODO: try an appraoch that deals with indicies on the stack rather than the temperature at that index instead..
        
        return result;
    
    }

    /* 
    * passes all the public tests locally but not on neetcode
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] result = new int[temperatures.length];
        // int tempToExceed = Integer.MIN_VALUE; // check this 
        Stack<Integer> s = new Stack<>();


        for (int i = 0; i < temperatures.length; i++)
        {
            // edge case: if you're ont the last day, nothing will exceed it
            if (i == temperatures.length - 1)
            {
                result[i] = 0;
            }
            else
            {
                s.push(temperatures[i]);
                int tempToExceed = temperatures[i];
                
                int j = i + 1;
                while (temperatures[j] <= tempToExceed && j < temperatures.length - 1)
                {
                    s.push(temperatures[j]);
                    j++;
                    
                }

                // if we've reached the end of the array and the only day on the stack is the current one, then set the result to 0           
                if (s.size() == 1 && j == temperatures.length - 1)
                {
                    result[i] = 0;
                }
                else
                {
                    result[i] = s.size();
                }
                s.clear();
            
            }
            
        }

        return result;
    }
    */ 

    public static void main(String[] args)
    {
        //int[] temperatures = {30,38,30,36,35,40,28}; // expected: [1,4,1,2,1,0,0]
        int[] temperatures = {22,21,20}; // expected: [2, 0, 0]
        int[] result = dailyTemperatures(temperatures); 
        for (int t : result)  
        {
            System.out.println(t);
        }
    }
}