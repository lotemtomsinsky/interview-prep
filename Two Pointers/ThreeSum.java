import java.util.*;

// https://neetcode.io/problems/three-integer-sum
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>(); // makes sure there are no duplicate triplets
        
       
        for (int p1 = 0; p1 < nums.length; p1++) {
        	for (int p2 = p1+1; p2 < nums.length; p2++) {
        		for (int p3 = p2+1; p3 < nums.length; p3++) {
                	if (nums[p1] + nums[p2] + nums[p3] == 0)
                	{
                		List<Integer> i = new ArrayList<>();
                		i.add(nums[p1]);
                		i.add(nums[p2]);
                		i.add(nums[p3]);
                		Collections.sort(i);
                		set.add(i);
                	}
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }
	
	public static void main(String[] args)
	{
		int[] n = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(n);
		System.out.println(result);
	}
		
}
