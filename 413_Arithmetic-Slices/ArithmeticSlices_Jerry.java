class Solution {

    /*
        1,2,3,4 => (1,2,3) , (2,3,4), (1,2,3,4)      
        : 1 + 2
        
        1,2,3,4,5 => (1,2,3), (2,3,4), (3,4,5) | (1,2,3,4) (2,3,4,5) | (1,2,3,4,5)    
        : 1 + 2 + 3
    */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        
        int count = 0;
        int sum = 0;
        for (int i=2; i<A.length; i++) {
            if((A[i]-A[i-1]) == (A[i-1]-A[i-2])) {
                sum += 1;
                count += sum;
            } else {
                sum = 0;                
            }            
        }
        return count;
    }

    private int mCount = 0;
    public int numberOfArithmeticSlices_old(int[] A) {
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