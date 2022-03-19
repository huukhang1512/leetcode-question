class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
        for(int i = 0; i < nums1.length; i++){
            minHeap.offer(List.of(nums1[i],nums2[0], 0));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < k && !minHeap.isEmpty(); i++){
            List<Integer> pair = minHeap.poll();
            res.add(List.of(pair.get(0), pair.get(1)));
            
            if(pair.get(2) < nums2.length-1){
                minHeap.add(List.of(pair.get(0),nums2[pair.get(2) + 1], pair.get(2) + 1));
            }
        }
        
        return res;
        
    }
}