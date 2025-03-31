/*
 * The idea behind selection sort is we consider the entire array to be unsorted at the start. Go through the array until you
 * find the index of the minimum value of the array and 'select' it. Swap the minimum with the first unsorted index, and
 * increment the first unsorted index. Continue this until all elements are in the sorted portion of the array
 */
public class SelectionSort {
    public static void sort(int[] a)
    {

        for (int i = 0; i < a.length; i++)
        {
            int minIndex = i;
            
            // if we're on the final element, it's considered sorted because there's nothing left to swap it with
            if (i == a.length - 1)
            {
                break;
            }

            for (int j = i; j < a.length; j++)
            {
                if (a[j] < a[minIndex]) { 
                   
                    minIndex = j;
                }
            }

            // swap min with first unsorted (aka min with i)
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp; // j - 1 bc it was indemented an extra time for the condition to be false

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
