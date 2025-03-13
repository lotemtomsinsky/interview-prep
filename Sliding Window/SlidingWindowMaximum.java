// https://neetcode.io/problems/sliding-window-maximum

public class SlidingWindowMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        //int[] window = new int[3];
        /*
         * need to count how many windows we have to determine size of the results array, since we need one max
         * value per window. The first window starts at 0 and ends at k - 1. The rest of the windows shift 1 
         * position to the right, and we know that the last window has to end at length - 1, and be size k so 
         * it starts at n - k. Therefore, there must be length - k + 1 windows possible, +1 since we start at 0
         */
        int[] results = new int[nums.length - k + 1];
        int winSeen = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++)
        {
            // if we've achieved the right window size
            if ((right - left + 1) == k)
            {
                for (int i = left; i <= right; i++)
                {
                    maxValue = Math.max(maxValue, nums[i]);
                }
                results[winSeen] = maxValue;
                /*
                 * once we've computed the max, we've need to:
                 * - move the window over to the right
                 * - check off we've seen it
                 * - reset the maxValue for the next window
                 */
                
                left++;
                winSeen++;
                maxValue = Integer.MIN_VALUE;
            }
        }

        return results;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,1,0,4,2,6};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int num: result)
        {
            System.out.println(num);
        }
        
    }
}
