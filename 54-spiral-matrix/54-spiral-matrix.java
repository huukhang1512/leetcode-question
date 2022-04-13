class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int size = matrix.length * matrix[0].length;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int up = 0;
        while(res.size() < size){
            for(int i = left; i <= right && res.size() < size; i++){
                res.add(matrix[up][i]);
            }
            up++;
            
            for(int i = up; i <= bottom && res.size() < size; i++){
                res.add(matrix[i][right]);
            }
            right--;
            
            for(int i = right; i >= left && res.size() < size; i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            
            for(int i = bottom; i >= up && res.size() < size; i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}