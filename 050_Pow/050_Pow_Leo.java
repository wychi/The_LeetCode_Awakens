class Solution {
    public double myPow(double x, int n) {
        if (0 == n) return 1;
        if (n < 0) {
            if (n == -n) return myPow(x, n+1)/x;
            n = - n;
            x = 1/x;
        }
        double ret = 1;
        double base = x;
        while (n > 0) {
            if ((n&1) == 1) ret *= base;
            base *= base;
            n >>= 1;
        }
        return ret;
    }
}
