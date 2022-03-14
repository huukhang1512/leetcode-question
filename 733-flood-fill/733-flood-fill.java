class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image;
        int currentColor = image[sr][sc];
        dfs(image, sr, sc, newColor,currentColor);
        return image;
    }
    public void dfs(int[][] image, int i, int j, int newColor, int currentColor){
        if(i < 0 || j < 0 || i > image.length - 1 || j > image[0].length -1 || image[i][j] != currentColor){
            return;
        }
        image[i][j] = newColor;
        dfs(image, i-1, j,newColor, currentColor);
        dfs(image, i+1, j,newColor, currentColor);
        dfs(image, i, j-1,newColor, currentColor);
        dfs(image, i, j+1,newColor, currentColor);
        
    }
}