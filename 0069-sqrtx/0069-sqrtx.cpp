class Solution {
public:
    int mySqrt(int n) {
        if (n <= 1)
            return n;

        int l = 1, r = n, ans;
        while (l <= r){
            int m = l + (r - l) / 2;
            if (m <= n/m){
                l = m + 1;
                ans = m;
            }
            else
                r = m - 1;
        }
        return ans;
    }
};