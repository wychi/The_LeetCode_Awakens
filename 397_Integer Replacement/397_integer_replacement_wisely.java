// Corner case 2^31 - 1
class Solution {
    public int integerReplacement(int n) {
        long rn = n;
        int step = 0;
        while (rn != 1) {
            if ((rn % 2) == 0) {
                rn /= 2;
            } else {
                rn += (addOne(rn) ? 1 : -1);
            }
            step++;
        }
        return step;
    }
    
    private boolean addOne(long n) {
        if (n == 3) return false;
        if ((n - 1) % 4 == 0) return false;
        return ((n + 1) % 4 == 0);
    }
}