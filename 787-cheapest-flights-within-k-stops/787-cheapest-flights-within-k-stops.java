class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src] = 0;
        
        for(int i =0; i <= k;i++){
            int[] tmpPrice = prices.clone();
            for(int[] flight : flights){
                if(prices[flight[0]] == Integer.MAX_VALUE){ 
                    // loop until we find a path to src (aka the source is 0 but not inf+)
                    continue;
                }
                // 
                if(prices[flight[0]] + flight[2] < tmpPrice[flight[1]]){ // cur price + the price of dst
                    tmpPrice[flight[1]] = prices[flight[0]] + flight[2];
                }
            }
            prices = tmpPrice;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
        
    }
}