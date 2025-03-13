// https://neetcode.io/problems/duplicate-integer

import java.util.HashMap;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int n : nums)
        {
            if (freq.containsKey(n))
            {
                return true;
            }
            else
            {
                freq.put(n, 1);
            }
        }

        return false;
    }
}
