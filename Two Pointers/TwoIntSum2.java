// https://neetcode.io/problems/two-integer-sum-ii

public class TwoIntSum2 {
	public static int[] twoSum(int[] numbers, int target) {
        // o(1) additional space means no extra arrays or hashsets
		int right = numbers.length-1;
		int[] indices = new int[2];
		
		for (int i = 0; i  < numbers.length; i++)
		{
			while (right > i)
			{	
				if (numbers[i] + numbers[right] == target)
				{
					indices[0] = i+1;
					indices[1] = right+1;
					break; // there's only 1 unique solution, so if we found it we can break
				}
				right--;
			}
			// restart right pointer at the end 
			right = numbers.length-1;
		}
		
		return indices;
    }
	
	
	public static void main(String[] args)
	{
		// test case 1:
//		int[] numbers = {-1, 0};
//		int target = -1;
		// expected output: [1,2]
		
		
		int[] numbers = {1,2,3,4};
		int target = 3;
		int[] results = twoSum(numbers, target);
		for (int n : results) {
			System.out.println(n);
		}

	}
}
