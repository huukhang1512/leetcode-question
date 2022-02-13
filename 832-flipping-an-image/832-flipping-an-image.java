class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] result = new int[image.length][image[0].length];
        for(int i = 0; i< image.length; i++){
            for(int j = image[0].length -1; j >= 0 ; j--){
                result[i][image[0].length - j - 1] = image[i][j];
                if(result[i][image[0].length - j - 1] == 1){
                    result[i][image[0].length - j - 1] = 0;
                } else {
                    result[i][image[0].length - j - 1] = 1;
                }
            }
        }
        return result;
    }
}