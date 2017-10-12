class Solution {
    private int getPalindromicLength(String s, int left, int right, int size) {
        for (;left >= 0 && right < size; left--, right++) {
            if (s.charAt(left) != s.charAt(right)) break;
        }
        return (right - left)/2;
    }
    public int countSubstrings(String s) {
        int ret = 0;
        for (int i = 0, len = s.length() ,size = len * 2 - 1; i < size; i++) {
            ret += getPalindromicLength(s, i/2, (i+1)/2, len);
        }
        return ret;
    }
}
