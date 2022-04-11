class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder cur, int open, int close, int n){
        if(cur.length() == n * 2){
            res.add(cur.toString());
        }
        
        if(open < n){
            cur.append("(");
            dfs(res, cur, open+1,close,n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open){
            cur.append(")");
            dfs(res, cur, open,close+1,n);
            cur.deleteCharAt(cur.length() - 1);
        }
        
    }
}