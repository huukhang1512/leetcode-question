class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        backtrack(res, nums, new ArrayList<>(),count);
        return res;
    }
    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tempList, HashMap<Integer, Integer> count){
        if(tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for(int num : count.keySet()){
            if(count.get(num) == 0) continue;
            count.put(num, count.get(num) - 1);
            
            tempList.add(num);
            backtrack(res, nums, tempList,count);
            
            tempList.remove(tempList.size() - 1); 
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }
}