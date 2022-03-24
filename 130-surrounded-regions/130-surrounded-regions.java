class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        if (board.length < 3 || board[0].length < 3)
            return;
    /*
        find the area with O only
        that dont have a cell on the border.
        
    */
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O'){
                dfs(i,0, board);
            }
            if(board[i][n-1] == 'O'){
                dfs(i,n-1,board);
            }
        }
        for(int i = 0; i < n; i++) {
            if(board[0][i] == 'O'){
                dfs(0,i, board);
            }
            if(board[m-1][i] == 'O'){
                dfs(m-1,i,board);
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    public void dfs(int i,int j, char[][] board){
        if(i < 0 ||  j < 0 || i > board.length - 1 || j > board[0].length -1 || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '*';
        
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
        
    }
}