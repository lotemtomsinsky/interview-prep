package BinarySearch;

// https://neetcode.io/problems/binary-search

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // we only stop looking if low exceeds high
        while (low <= high)
        {
            // this is the BS middle calculation formula
            int middle = low + (high - low) / 2;

            // first check if we've found the target
            if (nums[middle] == target)
            {
                return middle;
            }
            // if # at middle < target, then we can discard it and all #s before it. update low accordingly
            else if (nums[middle] < target)
            {
                low = middle + 1;
            }
            // only other option is # at middle > target, discard all #s after it and itself. update high accordingly
            else
            {
                high = middle - 1;
            }
        }
        
        // if we reach here, then the element didn't exist in the array. 
        return -1;
    }

    public static void main(String[] args)
    {
        /* 
        int[] nums = {-1,0,2,4,6,8};
        int target = 4;
        System.out.println(search(nums, target)); // expect 3
        */

        
        int[] nums = {-1,0,2,4,6,8};
        int target = 3;
        System.out.println(search(nums, target)); // expect -1
        
    }
}
