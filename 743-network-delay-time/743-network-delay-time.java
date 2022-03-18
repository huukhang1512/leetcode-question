class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap <Integer,Map<Integer, Integer>> edges = new HashMap<>();
        
        for(int i = 0; i < times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            edges.putIfAbsent(times[i][0], new HashMap<>());
            edges.get(times[i][0]).put(times[i][1], times[i][2]);
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        heap.add(new int[]{0, k});
        
        boolean[] visited = new boolean[n+1];
        int res = 0;
        
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int curNode = cur[1];
            int curTime = cur[0];
            
            if(visited[curNode]) continue;
            
            visited[curNode] = true;
            res = curTime;
            n--;
            if(edges.containsKey(curNode)){
                for(int next : edges.get(curNode).keySet()){
                    heap.add(new int[]{curTime + edges.get(curNode).get(next), next});
                }
            }
        }
        return n == 0 ? res : -1;
    }
}