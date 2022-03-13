class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums,dp, 0);
    }
    
    public boolean dfs(int[] nums, int[] dp, int start){
        if(start >= dp.length -1){
            return true;
        }
        
        if(nums[start] == 0){
            dp[start] = 0;
            return false;
        }
        
        if(dp[start] != -1){
            return dp[start] == 1; // true
        }
        int numOfJumps = nums[start];
        for(int i = 1; i <= numOfJumps;i++){
            if(dfs(nums,dp, i+start)){
                dp[i] = 1;
                return true;   
            }
        }
        
        dp[start] = 0;
        return false;
    }
}