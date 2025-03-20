package BinarySearch;

// https://neetcode.io/problems/search-2d-matrix

public class Search2DMatrix {

    /*
     * notes: must run in O(log(m*n)). Binary search only works on a 1D matrix.
     * Binary search is O(log n) so running binary search on each row of the m x n matrix leaves us with complexity
     * O(m * log(n))
     * Instead of seraching by row, treat the matrix as an array of length m x n rather than an m x n matrix. With this,
     * running binary search on an array of length m * n is O(log(m*n))
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // # rows
        int n = matrix[0]. length; // # columns
        // low as the first element, high as the last 
        int low = 0;
        int high = m * n - 1;
        

        // run binary search as usual, just add the conversion from index to 2D coordinate for target comparison
        while (low <= high)
        {
            int middle = low + (high - low) / 2;
            
            /*
             * now we need to convert the 1D index we have to 2D coordinates. 
             *
             * row = middle / n because when flattened, each 'complete' row has n elements so dividing by n gives us 
             * which row the middle value is located in
             * 
             * column = middle % n because the remainder of the index divided by n gives us the position within the 
             * row that the middle value is located at
             */
            int row = middle / n;
            int column = middle % n;

            if (matrix[row][column] == target)
            {
                return true;
            }
            else if (matrix[row][column] < target)
            {
                low = middle + 1;
            }
            else
            {
                high = middle - 1;
            }
        }

        return false; 
    }

    public static void main(String[] args)
    {
        /* 
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int target = 10;
        System.out.println(searchMatrix(matrix, target)); // expect true
        */
        
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
        int target = 15;
        System.out.println(searchMatrix(matrix, target)); // expect false
        
    }
}
