class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length() + 1] [text2.length() + 1];
        return solve(text1, text2, memo,0, 0);
    }
    
    public int solve(String text1, String text2, int[][] memo, int i, int j){
        if(i > text1.length() - 1 || j > text2.length() -1){
            return 0;
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1 + solve(text1, text2, memo, i+1, j+1); // move diaganolly
        } else {
            memo[i][j] = Math.max(solve(text1, text2, memo, i+1, j),solve(text1, text2, memo, i, j+1)); // move down and right
        }
        return memo[i][j];
    }
}