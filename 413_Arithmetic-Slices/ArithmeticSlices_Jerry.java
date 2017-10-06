class Solution {

    //TDOO improve
    private int mCount = 0;
    public int numberOfArithmeticSlices(int[] A) {
        mCount = 0;
        
        int start = 0;
        int end = start+2;
        while(end < A.length) {
            int diff = A[start+1] - A[start];
            for (int i=start+1; i<= end; i++) {
                if ((A[i+1] - A[i]) != diff) {
                    start++;
                    end = start+2;
                    break;
                }
                
                if (i+1 == end) {
                    mCount++;
                    
                    // reset if reach end
                    if (end == A.length-1) {
                        start++;
                        end = start+2;
                    } else {
                        end++;
                    }
                    break;
                }
            }
        }
        return mCount;
    }
    
    
}