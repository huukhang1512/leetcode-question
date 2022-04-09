class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < stones.length; i++){
            heap.add(stones[i]);
        }
        while(heap.size() >= 2){
            int largest = heap.poll();
            int secondLargest = heap.poll();
            if(largest > secondLargest){
                heap.add(Math.abs(largest - secondLargest));
            }
        }
        return heap.size() == 1 ? heap.poll() : 0;
    }
}