package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    // brute force approach, O(n^2) time complexity
    /*
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
                // if it's possible to extend, add extension to stack & move to the next rectangle
                if (heights[i] <= heights[j])
                {
                    s.push(j);
                    j++;
                }
                // otherwise stop considering, no more right extensions possible 
                else
                {
                    break;
                }
                
            }
            // compute any left extensions
            int k = i - 1;
            while (k >= 0)
            {
                // if it's possible to extend, add extension to stack & move to the next rectangle
                if (heights[i] <= heights[k])
                {
                    s.push(j);
                    k--;
                }
                // otherwise stop considering, no more left extensions possible 
                else
                {
                    break;
                }
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
    */

    // better solution, O(n) time complexity since each index is only pushed and popped from s at most once 
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        
        // Sentinel value to simplify width calculation
        s.push(-1);
        
        for (int i = 0; i < n; i++) {
            // If current bar is lower than the bar at stack top, pop and calculate area. The index popped is of the bar past
            // which we can't extend further right. When we pop an index, we 'start' further to the left the next time 
            while (s.peek() != -1 && heights[i] < heights[s.peek()]) {
                int height = heights[s.pop()];
                int width = i - s.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            s.push(i);
        }
        
        // Clear any remaining bars in the stack, with assumption that they extend to the end of the histogram
        while (s.peek() != -1) {
            int height = heights[s.pop()];
            int width = n - s.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }

    public static void main(String[] args)
    {
        // TODO: test case doesnt work, pre-computed widths are totally off. reference notebook, expected vals already calculated
        //int[] heights = {7,1,7,2,2,4}; // expected: 8 
        
        int[] heights = {1,3,7}; // expected: 7 this one works!!
       
        System.out.println(largestRectangleArea(heights)); 
    }
}
