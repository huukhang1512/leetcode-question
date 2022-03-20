
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int res = Integer.MAX_VALUE;
            int sum = 0;
            int start = 0 ;// start
            for(int i = 0; i < nums.length;i++){
                sum+= nums[i];
                while (sum >= target){
                    sum -= nums[start];
                    res = Math.min(res, i - start +1);
                    start++;
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
