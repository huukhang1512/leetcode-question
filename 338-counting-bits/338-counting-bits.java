class Solution {
    public int[] countBits(int n) {
        // O(nlogn)
        /*
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
        */
        
        // O(n)
        
        if(n == 0){
            return new int[]{0};
        }
        if(n == 1){
            return new int[]{0,1};
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                dp[i] = dp[i/2];
            } else {
                dp[i] =  1 + dp[i / 2];
            }
        }
        return dp;
        
    }
}