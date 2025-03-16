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
                s.push(i);
                int j = i+1;

                while (temperatures[j] <= temperatures[i] && j < temperatures.length - 1)
                {
                    j++;
                }

                if (temperatures[j] > temperatures[i])
                {
                    s.push(j);
                }

                if (s.size() == 1)
                {
                    result[i] = 0;
                }
                else
                {
                    int foundDay = s.pop();
                    int initDay = s.pop();
                    result[i] = foundDay - initDay;
                }
            }
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