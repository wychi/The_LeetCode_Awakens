class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long nl = Math.abs((long) n);
        double value = 1;
        double temp = 1;
        long d = 1L;
        int start = 1;
        while (nl > 0) {
            temp = (start == 1) ? x : temp * temp;
            if ((nl & d) > 0) {
                value *= temp; 
            }
            start++;
            nl >>= 1;
        }
        return n > 0 ? value : 1 / value;
    }
}