class Solution {
    public int findMin(int[] nums) {
        // binary search as the array should be sorted
        // find the part where the array rotate,
        // for O(n), just simply use Math.min.
        
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(nums[i],min);
        }
        return min;
    }
}