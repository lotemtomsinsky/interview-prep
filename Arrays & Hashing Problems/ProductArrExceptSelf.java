// https://neetcode.io/problems/products-of-array-discluding-self

public class ProductArrExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];

        products[0] = 1;//no elements before this 
        for (int i = 1; i < nums.length; i++)
        {
            products[i] = products[i-1] * nums[i-1];
        }

        int suffix = 1;
        for (int i = products.length - 1; i >= 0; i--)
        {
            products[i] *= suffix;
            suffix *= nums[i];
        }


        return products;

    }
}
