class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++){
            int count = 0;
            int cur = i;
            while(cur > 0){
                count+= cur%2;
                cur = cur/2;
            }
            res[i] = count;
        }
        return res;
    }
}