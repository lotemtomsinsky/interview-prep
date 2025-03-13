// https://neetcode.io/problems/trapping-rain-water

import java.util.*;
import java.util.Arrays;

public class TrappingRainWater {

	 public static int trap(int[] height) {
		 int tally = 0;
		 int[] prefix = new int[height.length];
		 int[] suffix = new int[height.length];
		 
		 // calculate the max prefix and suffix surrounding each index
		 for (int i = 0; i < height.length; i++)
		 {
			 // prefix
			 if (i == 0)
			 {
				 prefix[i] = height[i];
			 }
			 else {
				 int max = 0;
				 for (int j = 0; j < i; j++)
				 {
					 max = Math.max(max, height[j]);
				 }
				 prefix[i] = max;
			 }
			 
			 // suffix
			 if (i == height.length -1)
			 {
				 suffix[i] = height[i];
			 }
			 else {
				 int max = 0;
				 for (int j = i+1; j < height.length; j++)
				 {
					 max = Math.max(max, height[j]);
				 }
				 suffix[i] = max;
			 }
		 }
		 
		 for (int i = 0; i < height.length; i++)
		 {
			 int water = Math.min(prefix[i], suffix[i]) - height[i];
			 if (water >= 0)
			 {
				 tally += water;
			 }
		 }
		 
		 return tally;
	 }
	
	public static void main(String[] args)
	{
//		int[] h1 = {0,2,0,3,1,0,1,3,2,1};
//		System.out.println(trap(h1)); // expect 9
		
		int[] h2 = {4,2,0,3,2,5};
		System.out.println(trap(h2)); // expect 9


		
	}
}
