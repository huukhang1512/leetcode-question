class Solution {
    public int rob(int[] nums) {
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        
        dp[0] = nums[0]; // not stealing from the last house
        dp2[0] = 0; // steal from the last house, but ignore the first house
        dp2[1] = nums[1];

        for(int i = 1; i < nums.length -1; i++){
            int lastElement = 0;
            if(i-2 >= 0){
                lastElement = dp[i-2];
            }
            dp[i] = Math.max(lastElement + nums[i], dp[i-1]);
        }
        for(int i = 2; i < nums.length; i++){
            dp2[i] = Math.max(dp2[i-2] + nums[i], dp2[i-1]);
        }

        return Math.max(dp2[nums.length -1], dp[nums.length - 2]);
    }
}