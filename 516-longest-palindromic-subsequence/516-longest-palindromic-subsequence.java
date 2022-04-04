class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return dfs(s, 0, s.length() - 1, memo);
    }
    
    public int dfs(String s, int i, int j, int[][] memo){
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        if(i == j)
            return 1;
        if(i > j){
            return 0;
        }

        if(s.charAt(i) == s.charAt(j)){
            System.out.println(s.charAt(i));
            memo[i][j] += 2 + dfs(s,i + 1, j - 1,memo) ;// move anti-diagonaly
        } else {
            memo[i][j] = Math.max(
                dfs(s,i,j-1,memo),
                dfs(s,i+1,j,memo)
            );
        }
        return memo[i][j];
    }
}