class Solution {
    private static char OFFSET = 'a' - 'A';
    private char getChar(String s, int idx) {
        char c = s.charAt(idx);
        if (('A' <= c && c <= 'Z')) return (char)(c + OFFSET);
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9') ? c : 0;
    }
    public boolean isPalindrome(String s) {
        int l = 0, h = s.length() - 1;
        while (l < h) {
            char cl = getChar(s, l), cr;
            if (cl == 0) {
                l++;
            } else if ((cr = getChar(s, h)) == 0) {
                h--;
            } else {
                if (cl != cr) return false;
                l++;h--;
            }
        }
        return true;
    }
}
