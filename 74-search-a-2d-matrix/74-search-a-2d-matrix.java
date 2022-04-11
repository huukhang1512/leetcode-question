class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int i = 0; i < matrix.length;i++){
        //     for(int j = 0; j < matrix[0].length;j++){
        //         if(matrix[i][j] == target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        int i = 0;
        int j = matrix[0].length -1;
        while (i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                return true;
            } else if(matrix[i][j] > target){
                j--;
            } else {
                i++;
            }
        }
        return false;
        
        /* 
            i = 12 => [2][3] [length() - 1][length[0] - 1]
            i = 11 => [2][2] [length() - 1][length[0] - 2]
            ...
            i = 6 => [1][2] [length()-1 / 2][Math.ceil(length[0] - 1 / 2)]
        */
        
    }
}