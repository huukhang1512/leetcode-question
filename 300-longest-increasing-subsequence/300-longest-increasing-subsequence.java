class Solution {
    // recursion + cache
    /*
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length + 1];
        return dfs(nums,0,-1);
    }
    
    public int dfs(int[] nums, int i, int prev_i){
        if(i >= nums.length) return 0;
        if(dp[prev_i + 1] != 0) return dp[prev_i + 1];

        int take = 0;
        int dontTake = dfs(nums, i+1, prev_i);

        if(prev_i == -1 || nums[i] > nums[prev_i])
            take = 1 + dfs(nums, i+1, i);
        
        dp[prev_i+1] = Math.max(take, dontTake);
        
        return dp[prev_i + 1];
    }
    */
    
    //bottomUp
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); // for every element, there always exist one choice
        int max = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
