class Solution {
    public int countSubstrings(String s) {
        final int len = s != null ? s.length() : 0;
        if (len <= 0) return 0;
        int count = 0;
        for (int i = 0 ; i < len; i++) {
            count += countPalindrom(s, i, i); //odd
            count += countPalindrom(s, i, i+1);//even
        }
        return count;
    }
    private int countPalindrom(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length()-1 && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        
        return count;
    }
}
