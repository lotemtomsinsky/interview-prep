// https://neetcode.io/problems/buy-and-sell-crypto

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++)
        {
            // track the min price we've seen
            minPrice = Math.min(minPrice, prices[i]);

            // calculate potential profit & update the max profit we've seen so far
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args)
    {
        //int[] prices = {10,1,5,6,7,1}; // expect 6
        int[]  prices = {10,8,7,5,2}; // expect 0
        System.out.println(maxProfit(prices));
    }
}
