class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while(n > 1) {
            if(n%2 == 0)
                n = n >>> 1;
            else {
                int mask = 1 << 1;
                if((n & mask) == mask && n != 3) {
                    if(n+1 < n) {
                        n = n >>> 1;
                    } else {
                        n = n+1;
                    }
                } else {
                    if(n+1 < n) {
                        // underflow
                        n = n >>> 2;
                    } else {
                        n = n-1;
                    }
                }
            }
            count++;
        }
        
        return count;
    }
    
    public int integerReplacement1(int ni) {
        int count = 0;
        long n = ni;
        while(n > 1) {
            if(n%2 == 0)
                n = n/2;
            else {
                int mask = 1 << 1;
                if((n & mask) == mask && n != 3) {
                    n = n+1;
                } else 
                    n = n-1;
            }
            count++;
        }
        
        return count;
    }
}
