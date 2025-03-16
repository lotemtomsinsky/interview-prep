package Stack;

import java.util.Stack;

// https://neetcode.io/problems/daily-temperatures

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();  

        for (int i = 0; i < temperatures.length; i++)
        {
            // edge case: if you're on the last day, nothing will exceed it
            if (i == temperatures.length - 1)
            {
                result[i] = 0;
            }
            else
            {
                // store which day we're on
                s.push(i);
                int j = i+1;

                // starting the next day, keep iterating until we find an exceeding temp or we reach the end of the list 
                while (temperatures[j] <= temperatures[i] && j < temperatures.length - 1)
                {
                    j++;
                }

                // if the case is that an exceeding temp is found, push the day it's on onto the stack
                if (temperatures[j] > temperatures[i])
                {
                    s.push(j);
                }
                // if the case is that no exceeding temp is found, set the result to 0
                if (s.size() == 1)
                {
                    result[i] = 0;
                }
                else
                {
                    // the top of the stack will be the latter day
                    int foundDay = s.pop();
                    int initDay = s.pop();
                    // the diff between the days is how many days it took for it to get warmer
                    result[i] = foundDay - initDay;
                }
            }
            // clear because if no exceeding temp is found, the stack will have an extra element remaining since the pops aren't performed
            s.clear();
        }
        
        return result;
    
    }

    public static void main(String[] args)
    {
        int[] temperatures = {30,38,30,36,35,40,28}; // expected: [1,4,1,2,1,0,0]
        //int[] temperatures = {22,21,20}; // expected: [0,0,0]
        //int[] temperatures = {30,40,50,60}; // [1,1,1,0]
        int[] result = dailyTemperatures(temperatures); 
        for (int t : result)  
        {
            System.out.println(t);
        }
    }
}