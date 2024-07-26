package arraysAndSorting.arraysMed;

public class StockBuyAndSell {
    public int maxProfit(int[] prices) {
        /**
         * Bruteforce: Iterate over all the subarrays that represent all possible transactions.
         * - Then we store the maximum profit in a variable.
         * - Here 2 loops are used.
         * - TC: O(N^2) SC: O(1)
         *
         * Optimal Approach: If we want to sell a stock on ith day, Then we buy it at minimum price between 1st and (i-1) day
         * - Here, we linearly traverse the array and track the minimum price.
         * - If price is greater than the mini, then we take price difference and store the max profit.
         * - We compare minPrice and maxProfit at each iteration.
         * - TC: O(N) SC:O(1)
         *
         * */
        int minPrice = prices[0];
        int maxProfit = 0;
        // Iterate over the array
        for(int i=1; i < prices.length; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
