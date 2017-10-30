class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n>>>=1;
            } else {
                n += ( (n & 2) == 2 && (n != 3)) ? 1 : -1;
            }
            count++;
        }
        return count;
    }
}
