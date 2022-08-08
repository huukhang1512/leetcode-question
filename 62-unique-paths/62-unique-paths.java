class Solution {
    public Map<String,Integer> map = new HashMap<>();
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1 ){
            return 1;
        }
        String cell = m + "," + n;
        if(map.containsKey(cell)) return map.get(cell);
        int numOfWaysDown = uniquePaths(m-1, n);
        int numOfWaysRight = uniquePaths(m, n-1);
        int total = numOfWaysDown + numOfWaysRight;
        map.put(cell,total);
        return total; 
    }
}