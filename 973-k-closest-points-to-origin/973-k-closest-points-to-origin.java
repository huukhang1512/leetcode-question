class Solution {
    public int  compare(int[] pointA, int[] pointB){
        int distanceA = (int) (Math.pow(pointA[0],2) + Math.pow(pointA[1],2));
        int distanceB = (int) (Math.pow(pointB[0],2) + Math.pow(pointB[1],2));
        
        return distanceA - distanceB;
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> compare(a,b));
        for(int[] point : points){
            heap.offer(point);
        }
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}