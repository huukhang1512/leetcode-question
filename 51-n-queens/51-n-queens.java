class Solution {
    private Set<Integer>colSet = new HashSet<>();
    private Set<Integer>digSet = new HashSet<>(); // diagonal
    private Set<Integer>antiDigSet = new HashSet<>(); // anti diagonal


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res,new ArrayList<String>(),0,n);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> current, int row, int n){
        if(row == n){
            res.add(new ArrayList<String>(current));
            return;
        }
        for(int i = 0; i < n; i++){
            if(colSet.contains(i) || digSet.contains(row+i) || antiDigSet.contains(row-i)) continue;
            char[] charArr = new char[n];
            Arrays.fill(charArr, '.');
            charArr[i] = 'Q'; // placing a queen at this position
            
            current.add(new String(charArr));
            
            colSet.add(i);
            digSet.add(row + i);
            antiDigSet.add(row - i);

            dfs(res, current, row+1, n);
            
            current.remove(current.size() - 1);
            colSet.remove(i);
            digSet.remove(row + i);
            antiDigSet.remove(row - i);
        }
    }
    
}
