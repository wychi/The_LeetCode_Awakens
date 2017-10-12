class Solution {
    public double myPow(double x, int n) {
        if (0 == n) return 1;
        if (n < 0) {
            if (n == -n) {
                return myPow(x, n+1)/x;
            }
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        while (n > 0) {
            if((n&1) == 1) ans *= x;  // 1 == (n&1)  => 1 == (n % 2)
            x *= x;
            n >>= 1;
        }
        
        return ans;
    }
}
