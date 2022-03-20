class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        int ans = dfs(dp,coins, amount);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public int dfs(int[] memo, int[] coins, int remain){
        if(memo[remain] != -1){
            return memo[remain];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= remain){
                int ans = dfs(memo, coins, remain - coins[i]);
                if(ans != Integer.MAX_VALUE)
                    res = Math.min(res, ans + 1);
            }
        }
        memo[remain] = res;
        return memo[remain];
    }
}