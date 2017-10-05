class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        final int size = null != A ? A.length : 0;
        if (size < 0) {
            return 0;
        }
        
        int result = 0, count = 0;
        for (int i = 2; i<A.length ; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                count += 1;
                result+=count;
            } else {
                count = 0;
            }
        }
        return result;
    }
}
