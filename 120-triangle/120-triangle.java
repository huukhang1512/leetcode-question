class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        // initially, each element in the dp array is 0
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
                // start from the bottom row and work upward
            }
        }
        return dp[0];
    }
}