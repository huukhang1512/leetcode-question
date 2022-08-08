class Solution {
    private Map<String, Integer> map = new HashMap<String, Integer>();
    public int uniquePaths(int m, int n) {

        if(m == 1 || n == 1) return 1;
        
        String cell = new String(m + "," + n);
        if(map.containsKey(cell)) 
            return map.get(cell);
        
        int down = uniquePaths(m-1, n);
        int right = uniquePaths(m, n-1);
        
        map.put(cell, down + right);
        
        return down + right;
    }    
}