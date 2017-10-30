class Solution {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n%2 == 0) {
            return 1+integerReplacement(n/2);
        }
        
        if (n == 2147483647) {
            return 2+integerReplacement(n/2+1);
        }
        
        if (n == -2147483648) {
            return 2+integerReplacement(n/2-1);
        }
        
        if (n > 4 && (n+1)%4 == 0) {
            return 1+integerReplacement(n+1);
        }
        
        return 1+integerReplacement(n-1);
    }
}