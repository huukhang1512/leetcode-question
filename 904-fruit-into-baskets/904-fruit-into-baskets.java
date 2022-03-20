class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int result = 0;
        while (end < fruits.length){
            map.put(fruits[end],map.getOrDefault(fruits[end],0) + 1);
            while(start < end && map.size() > 2){
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start]) == 0){
                    map.remove(fruits[start]);
                    
                }
                start++;
            }
            result = Math.max(result,end-start+1);
            end++;
        }
        return result;
        
        /*
        - init a hashmap with the number of tree each type has during each iteration
        - once the size of the hashmap exceed 2, create a loop that will decrease the number of fruit in each tree by one, if the number hits zero, remove that item
        - decrease the window by increase the start.
        store the result by get the end - start + 1
        */
    }
}