// https://neetcode.io/problems/max-water-container

public class MaxWaterContainer {
	 public static int maxArea(int[] heights) {
	     
		 int max = 0;
		 
		 for (int i = 0; i < heights.length; i++)
		 {
			 for (int j = i+1; j < heights.length; j++)
			 {
				 /*
				  * the water can go max up until the shorter wall, this is the height. the width of the container.
				  * the width of the container is the distance between the two walls
				  */
				 int area = Math.min(heights[i], heights[j]) *  (j-i);
				 max = Math.max(max, area);
			 }
		 }
		 
		 return max;
	 }
	 
	 public static void main(String[] args)
	 {
		 int[] height = {1,7,2,5,4,7,3,6};
		 int result  = maxArea(height);
		 System.out.println(result);
	 }
	 
}
