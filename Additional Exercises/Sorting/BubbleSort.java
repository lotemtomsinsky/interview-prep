public class BubbleSort {
    
    public static void sort(int[] array)
    {
        boolean swapped = false;

        // go to len - 1 to avoid out of bounds errors & unecessary comparisons
        for (int i = 0; i < array.length - 1; i++)
        {
            swapped = false;

            // look at adjacent elements, swap them if they're in the wrong order. After each pass, the largest element
            // is bubbled up to the end, so we don't need to consider the last i elements as they're sorted in each pass
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // if no swaps happened in the inner loop, then the array is sorted and we can stop this 
            if (!swapped)
            {
                break;
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
