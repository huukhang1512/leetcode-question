class Solution {
    public boolean exist(char[][] board, String word) {
        int cols = board[0].length;
        int rows = board.length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(word.charAt(0) == board[i][j] && dfs(i,j,board, word, 0)){
                    return true;
                }   
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] grid,String word, int curIndex){
        if(curIndex == word.length()){
            return true;
        }
        if(i > grid.length - 1 || j > grid[0].length -1 || i < 0 || j < 0 || grid[i][j] == '*' || grid[i][j] != word.charAt(curIndex)){
            return false;
        }
        char temp = grid[i][j];
        grid[i][j] = '*';
        boolean found = dfs(i+1,j,grid, word,curIndex+1) 
            || dfs(i-1, j, grid, word, curIndex + 1) 
            || dfs(i, j+1, grid, word, curIndex + 1) 
            || dfs(i, j-1, grid, word, curIndex + 1);
        grid[i][j] = temp;
        return found;
    }
}