class Solution {
    public int maximumTop(int[] nums, int k) {
        if(nums.length == 1 && k % 2 != 0) {
            return -1;
        }
        
        
        int toLook = k <= nums.length ? k - 1 : nums.length;
        int maxSoFar = -1;
        for(int i = 0; i < toLook; i++) {
            maxSoFar = Math.max(nums[i], maxSoFar);
        }
        int lastElement = k < nums.length ? nums[k] : 0;
        return Math.max(maxSoFar, lastElement);
    }
}