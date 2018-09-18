//Time:O(N)
//Space:O(1)
class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0 ; i<s.length()/2; i++) {
            int hi = s.length()-1-i;
            if (s.charAt(i) != s.charAt(hi)) {
                return isPalindrome(s, i, hi-1) || isPalindrome(s, i+1, hi);
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }
}
