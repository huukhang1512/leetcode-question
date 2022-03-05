class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i = 1;i< nums.length;i++){
            int tempMax = max;
        
            // equivalent to Math.max/min between 3 var current nums, current max * num, and cur min * num
            // Math.max(curNum, curMax * curNum, curMin * curNum)
            max = Math.max(nums[i], Math.max(max*nums[i], min * nums[i]));
            
            // Math.min(curNum, curMax * curNum, curMin * curNum)
            min = Math.min(nums[i], Math.min(tempMax*nums[i], min * nums[i]));   
            res = Math.max(res,max);
        }
        return res;
    }
}