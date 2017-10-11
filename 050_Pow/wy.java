class Solution {
    public double myPow(double x, int n) {
        if(n == 0 )
            return 1;

        double extra = 1.0;
        if(n%2 == 1 || n%2 == -1) {
            extra = n > 0 ? x : 1/x;
        }
        int m = n/2;
        if(m < 0) {
            m = -m;
            x = 1/x;
        }
        
        return myPow(x*x , m) * extra;

    }
}
