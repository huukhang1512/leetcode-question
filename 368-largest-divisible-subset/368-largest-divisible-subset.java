class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int max = 0, end = -1;
        int[] dp = new int[nums.length];
        int[] maxIndex = new int[nums.length];
        
        Arrays.fill(dp,1);
        Arrays.fill(maxIndex,-1);
        for(int i = 0; i < nums.length; i++){
            for(int j = i-1; j >=0;j--){
                if(nums[i] % nums[j] == 0 ||
                   nums[j] % nums[i] == 0){
                    if(1 + dp[j] > dp[i]){
                        dp[i] = Math.max(dp[i], dp[j]+1);
                        maxIndex[i] = j;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                end = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(end != -1){
            ans.add(nums[end]);
            end = maxIndex[end];
        }
        return ans;
    }
}