class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int start = 0;
        int curSum = 0;
        int end = 0;
        while(end < nums.length){
            curSum += nums[end];
            while(curSum >= target){
                curSum -= nums[start];
                res = Math.min(res, end - start + 1);
                start++;
            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}