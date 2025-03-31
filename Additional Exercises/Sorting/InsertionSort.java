/*
 * The idea behind insertion sort is to consider the array as split into sorted and unsorted, where at first sorted is just
 * the first element and the rest of the array is unsorted. Then, starting at the second element, we go backwards through
 * the array swapping it down as long as the current < adjacent. Do this for all the elements in the list to insert them 
 * into their appropriate spot.
 */
public class InsertionSort {
    
    public static void sort(int[] a)
    {
        // consider the first element to be sorted. Start at second
        for (int i = 1; i < a.length; i++)
        {
            // compare with all elements to the left of the current element. If prev > current, swap prev to the right until
            // prev <= current
            for (int j = i; j > 0; j--)
            {
                if (a[j - 1] > a[j])
                {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = {5,3,1,2,4};
        sort(a);
        for (int el : a)
        {
            System.out.println(el);
        }
    }
}