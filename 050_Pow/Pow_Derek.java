class Solution {
// Fast Power Algorithm Recursive
    //Time: O(logN)
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -n;
            x = 1/x;
        }
        return fastPow(x, N);
    }
    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half*x;
        }
    }
//Method 2: From solution First 1
	public double myPow(double x, int n) {
        boolean positive = n > 0;
        double result = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
        }

        return positive ? result : 1 / result;
	}

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
