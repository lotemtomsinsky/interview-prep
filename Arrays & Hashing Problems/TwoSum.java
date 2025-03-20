// https://neetcode.io/problems/two-integer-sum

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int left = 0; left < nums.length - 1; left++)
        {
            for (int right = left + 1; right < nums.length; right++)
            {
                if (nums[left] + nums[right] == target)
                {
                    result[0] = left; 
                    result[1] = right;
                    break; // since there's guaranteed to be only 1 solution, once we find it we can break
                }
            }
        }

        return result;
    }
}
