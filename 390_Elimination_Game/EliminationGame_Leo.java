class Solution {
//Complexity: O(ln(n)), for 32-bit, the while loop at most 31 times;
    public int lastRemaining(int n) {
        int a0 = 1, d = 1;
        boolean odd = true;
        while ( n > 1) {
            if (odd) {
                a0 += d;
            } else {
                if ((n & 1) == 1) a0 += d;
            }
            n >>>= 1;
            d <<= 1;
            odd = !odd;
        }
        return a0;
    }
    
//Complexity: O(ln(ln(n))), for 32-bit: the while loop at most 5 times
                                64-bit:                        6 times
    public static int lastRemaining(int n) {
        /* 'base' is power of 2 and the largest number which are not large than n,
           ex/ if n == 0xd, 'base': 8,
                  n == 0x10, 'base': 16
           An easy way to get 'base' is by binary search. 
           The following implementation provides another bit-wise method
         */
        int base = n;
        int d = 1;
        while (d <= 16) {
            base |= base>>d;
            d <<= 1;
        }
        base -= base>>1;
        // (n-base) set the left most bit to 0
        // ((base-1) & 0x55555555) => get a mask that set all the even bits smaller than 'base' to 1       
        return 1 + ( (n-base) | ((base-1) & 0x55555555) );
    }
}
