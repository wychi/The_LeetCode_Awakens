class Solution {
    public int lastRemaining(int n) {
        return helper(n, true);
    }
    
    private int helper(int n, boolean leftDir) {
        if (n == 1) {
            return n;
        } else if (leftDir){
            // consider as find sequnce (1, 2, 3.... n/2)
            return 2 * helper(n/2, false);
        } else {
            // if n is odd, mirror as (1, 2, 3.... n/2)
            // else if n is even, mirror as (1, 2, 3.... n/2) - 1
            return 2 * helper(n/2, true) - ((n % 2 == 0) ? 1: 0);
        }
    }
}