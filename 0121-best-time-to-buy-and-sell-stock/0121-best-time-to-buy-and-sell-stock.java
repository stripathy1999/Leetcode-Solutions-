class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for(int price : prices){
            minPrice = Math.min(minPrice, price);

            int profit = price - minPrice;

            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}