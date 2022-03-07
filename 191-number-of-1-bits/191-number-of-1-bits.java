public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cur = n;
        int count = 0;
        while(cur != 0){
            count += cur & 1;
            cur = cur >>> 1; // unsigned shift bits on the right by 1
        }
        return count;
    }
}