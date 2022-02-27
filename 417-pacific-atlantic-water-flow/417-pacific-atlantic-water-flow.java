class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length; 
        int m = heights[0].length;
        /*
        atlantic index = lastcol and last row (heights[heights.length - 1], height[n][m]);
        pacific index = firstrow and firstcol (heights[0], height[i][0]);
        */
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];
        
        for(int i = 0; i < n;i++){
            dfs(heights, i, 0, heights[i][0], pacific);  // left
            dfs(heights, i, m-1, heights[i][m-1], atlantic); // right
        }
        
        for(int i = 0; i < m;i++){
            dfs(heights, 0, i, heights[0][i], pacific); // top
            dfs(heights, n-1, i, heights[n-1][i], atlantic); //down
        }

        // find the cell where both pacific and atlantic overlap, meaning the field that both the cell can reach both atlantic and pacific
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(i);
                    curRes.add(j);
                    result.add(curRes);
                }
            }
        }
        return result;
        
    }
    public void dfs(int[][] matrix, int i, int j, int curHeight, boolean[][] ocean){
        if  (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || 
            curHeight > matrix[i][j] || ocean[i][j] 
            // this is the main logic, indicate that it can flow to the neighbour cells
            )
        {
            return;
        }
        ocean[i][j] = true;
        dfs(matrix, i+1, j, matrix[i][j],ocean);
        dfs(matrix, i-1, j, matrix[i][j],ocean);
        dfs(matrix, i, j+1, matrix[i][j],ocean);
        dfs(matrix, i, j-1, matrix[i][j],ocean);
    }
}