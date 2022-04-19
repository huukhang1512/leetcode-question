class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for(int i = 0; i < 3; i++){
            while(map.containsKey(i) && map.get(i) != 0){
                nums[index++] = i;
                map.put(i, map.get(i) - 1);
            }
        }
    }
}