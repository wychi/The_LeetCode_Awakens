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
        /* base is power of 2 and the largest number which are not large than n,
           ex/ if n == 0xd, base: 8,
                  n == 0x10, base: 16
           you can base by simply binary search. The following implementation is another bit-wise method
         */
        int base = n;
        int d = 1;
        while (d <= 16) {
            base |= base>>d;
            d <<= 1;
        }
        base -= base>>1;
        //0x55555555 => extract even bits
        //0xaaaaaaaa => extract odd bits
        return 1+((base-1) & 0x55555555) + ((n-base) & 0xaaaaaaaa);
    }
}