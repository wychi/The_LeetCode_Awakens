//Time: log N (base 5)
//Space: O(1)
class Solution {
    //recursive
    // public int trailingZeroes(int n) {
    //     return 0 == n ? 0 : n/5 + trailingZeroes(n/5);
    // }
    
    //iterative
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }
}
