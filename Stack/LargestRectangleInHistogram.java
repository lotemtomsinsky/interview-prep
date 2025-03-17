package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int[] widths = new int[heights.length];
        
       // precompute how far we can extend the bar at position i to the right and left, this will give us the max possible width
       // for a rectangle formed with the height at heights[i]
       for (int i = 0; i < heights.length; i++)
       {
            // it can always at least have a width of 1, the bar itself
            s.push(i); 
            // compute any right extensions
            int j = i + 1;
            while (j <= heights.length - 1)
            {
                if (heights[i] <= heights[j])
                {
                    s.push(j);
                }
                j++;
            }
            // compute any left extensions
            int k = i - 1;
            while (k >= 0)
            {
                if (heights[i] <= heights[k])
                {
                    s.push(j);
                }
                k--;
            }
            widths[i] = s.size();
            s.clear();
       }

       int max = Integer.MIN_VALUE;
       // since the we maximized the widths of the rectangles for each height heights[i], all that's left is to find the max
       // area of all the possible areas
       for (int i = 0; i < heights.length; i++)
       {
            max = Math.max(max, heights[i] * widths[i]);
       }

       return max;
    }

    public static void main(String[] args)
    {
        // TODO: test case doesnt work, pre-computed widths are totally off. reference notebook, expected vals already calculated
        int[] heights = {7,1,7,2,2,4}; // expected: 8 
        
        //int[] heights = {1,3,7}; // expected: 7 this one works!!
       
        System.out.println(largestRectangleArea(heights)); 
    }
}
