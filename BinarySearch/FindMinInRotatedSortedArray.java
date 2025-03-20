package BinarySearch;

// https://neetcode.io/problems/find-minimum-in-rotated-sorted-array

public class FindMinInRotatedSortedArray {
    /*
     * want to perform binary search to find the point at which nums[i] > nums[i + 1], because this is where the
     * sorting gets disrupted due to the rotations. then, i + 1 is the index at which the min value of the array 
     * resides. If such point doesn't exist, then the array was rotated n times, and minimum element is at index 0
     */
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high)
        {
            // the potential index of the inflection point
            int middle = low + (high - low) / 2;
            
            
            // if in a sorted array the middle element is greater than the last element, then the minimum must be on
            // the right side 
            if (nums[middle] > nums[high])
            {
                low = middle + 1;
            }
            // otherwise the minimum is on the left side 
            else
            {
                high = middle;
            }
           
        }

        // left and right will eventually converge, and they'll point at the minimum element
        return nums[low];
    }
}
