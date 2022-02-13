class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> oddMap = new HashMap<>();
        HashMap<Integer,Integer> evenMap = new HashMap<>();
        
        
        PriorityQueue<Map.Entry<Integer,Integer>> oddHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Integer,Integer>> evenHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        for(int i = 0; i < nums.length;i+=2){
            evenMap.put(nums[i],evenMap.getOrDefault(nums[i],0)+1);
        }
        
        
        for(int i = 1; i < nums.length;i+=2){
            oddMap.put(nums[i],oddMap.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry entry: oddMap.entrySet()){
            oddHeap.offer(entry);
        }
        
        for(Map.Entry entry: evenMap.entrySet()){
            evenHeap.offer(entry);
            
        }
         
        int max = 0;
        if(oddHeap.isEmpty() || evenHeap.isEmpty()){
            return 0;
        }
        if (evenHeap.peek().getKey() != oddHeap.peek().getKey()){
            max = evenHeap.peek().getValue() + oddHeap.peek().getValue();
        }else{
            int maxEven = evenHeap.poll().getValue();
            int secEven = evenHeap.isEmpty() ? 0 : evenHeap.poll().getValue();
            int maxOdd = oddHeap.isEmpty() ? 0 : oddHeap.poll().getValue();
            int secOdd = oddHeap.isEmpty() ? 0 : oddHeap.poll().getValue();
            max = Math.max(maxEven + secOdd, secEven + maxOdd);
        }

        return nums.length - max;
        
    }
}