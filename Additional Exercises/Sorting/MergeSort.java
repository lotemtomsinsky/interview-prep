/*
 * The idea behind this sorting algorithm is to recursively split the list into two halves until you're left with single elements, in which case those are considered 
 * sorted. Then, you merge the sorted elements from left and right subarrays in ascending order, and this propogates up through the calls until the entire array is sorted.
 * For this we need to implement 2 methods: mergesort which makes the recursive call, and merge which combines the subarrays and sorts them
 * subarrays back together
 */

public class MergeSort {
    
    public static void mergesort(int[] a, int l, int r)
    {
        if (l < r)
        {
            int m = l + (r - l) / 2;
            mergesort(a, l, m);
            mergesort(a, m + 1, r);

            merge(a, l, r, m);
        }
        // don't need to return a because merge does the swaps in it, so it's modified on the fly
    }

    private static void merge(int[]arr, int l, int r, int m)
    { 
        // sizes for the two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // copy data into the temp arrays
        for (int i = 0; i < n1; i++)
        {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++)
        {
            right[j] = arr[m + 1 + j];
        }

        // now we want to merge the subarrays into the array
        // indicies for the subarrays
        int i = 0, j = 0;
        // index we want to start in for the merged array (start from leftmost position)
        int k = l;

        while (i < n1 && j < n2)
        {
            // make sure we don't skip elements that are =, take from left because this is stable sort
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // if there are any leftover elements in either subarray, copy them over. start with left subarray
        while (i < n1)
        {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = right[j];
            j++;
            k++;
        }

    }
    
    public static void main(String[] args)
    {
        int[] a = {5,3,1,2,4};
        //int[] a = {3,1,2,4};
        mergesort(a, 0, a.length - 1);
        for (int el : a)
        {
            System.out.println(el);
        }
    }
}
