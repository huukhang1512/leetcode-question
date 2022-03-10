class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int res = 0;
        for(int num: set){
            if(!set.contains(num -1)){
                int cur = 0;
                while(set.contains(num++)){
                    cur++;
                }   
                res = Math.max(res,cur);
            }
        }
        return res;
    }
}