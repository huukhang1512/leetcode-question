class Solution {
    public int findMin(int[] nums) {
        // binary search as the array should be sorted
        // find the part where the array rotate,
        // for O(n), just simply use Math.min.
        
        // O(n)        
        /*int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(nums[i],min);
        }
        return min;*/
        
        // What I know
        /*
        i'm pretty sure the first item would always more than the last Item
        
        */
        
        if(nums[0] < nums[nums.length -1]){
            return nums[0];
        }
        if(nums.length == 1){
            return nums[0];
        }
                
        int left = 0;
        int right = nums.length - 1;
        while(right >= left){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] > nums[mid + 1]){
                return nums[mid+1];
            }
            if (nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            
            if(nums[mid] > nums[0]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
        
    }
}