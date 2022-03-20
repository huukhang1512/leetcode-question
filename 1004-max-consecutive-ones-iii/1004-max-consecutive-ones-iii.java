class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int count = 0;
        int res = Integer.MIN_VALUE;
        while(end < nums.length){
            if(nums[end] == 0){ // count the num of 0 that you need to flip
                count++;
            }
            while(count > k && start < nums.length){
                if(nums[start] == 0){
                    count--;
                }
                start++;
            }
            res = Math.max(res, end-start + 1);
            end++;
        }
        
        return res == Integer.MIN_VALUE ? ((count <= k) ? nums.length : 0 ) : res;
        
    }
}