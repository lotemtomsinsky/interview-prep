// https://neetcode.io/problems/longest-consecutive-sequence

import java.util.HashSet;

public class LongestConsecSequence {

	 public static int longestConsecutive(int[] nums) {
		
		 if (nums.length == 0)
		 {
			 return 0;
		 }
		 
		int maxLength = 0;
		int currentLength = 0;
		
        HashSet<Integer> allNums = new HashSet<>();
        
        // add all the values into the hashset so we can go through it 
        for (int num: nums)
        {
        	allNums.add(num);
        }
        
        for (int num : nums)
        {
        	if (!allNums.contains(num-1))
        	{
        		int currNum = num;
        		currentLength = 1;
        		
        		while (allNums.contains(currNum+1))
        		{
        			currentLength++;
        			currNum++;
        		}
        		
        		maxLength = Math.max(maxLength, currentLength);
        	}
        }
		
		return maxLength;
    }
	 
	 public static void main(String[] args)
	 {
		 int[] nums= {2,20,4,10,3,4,5};
		 System.out.println(longestConsecutive(nums));
		 
	 }
}
