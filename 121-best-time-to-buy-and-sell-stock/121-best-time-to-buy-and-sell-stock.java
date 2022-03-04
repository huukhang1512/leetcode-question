class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length;i++){
            dp[i] = Math.min(dp[i-1],prices[i]);
            int curProfit = prices[i] - dp[i];
            profit = Math.max(profit,curProfit);
        }
        return profit;
    }
}