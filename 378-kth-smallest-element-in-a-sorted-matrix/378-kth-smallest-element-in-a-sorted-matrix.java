class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                heap.add(matrix[i][j]);
            }
        }
        int result = 0;
        while(k > 0){
            result = heap.poll();
            k--;
        }
        return result;
    }
}