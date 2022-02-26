class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length == 0 || isConnected[0].length == 0){
            return 0;
        }
        int n = isConnected.length;
        int m = isConnected[0].length;
        
        DisjointSet ds = new DisjointSet(n);
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < m; j++){
                if(isConnected[i][j] == 1) {
                    ds.unite(i,j);
                }
            }
        }
        
        for(int i = 0; i < n;i++){
            ds.parents[i] = ds.find(i);
            set.add(ds.parents[i]);
        }
        return set.size();
        
    }
}

class DisjointSet {
    int[] parents;
    public DisjointSet(int size){
        parents = new int[size];
        for(int i = 0; i < size; i++){
            parents[i] = i;
        }
    }
    public int find(int x){
        if (parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    
    public void unite(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        parents[parents[y]] = parentX;
    }
}