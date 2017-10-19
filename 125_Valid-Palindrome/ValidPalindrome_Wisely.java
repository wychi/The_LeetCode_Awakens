class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) return true;
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char ss = s.charAt(start);
            if ((ss >= 'a' && ss <= 'z') || (ss >= '0' && ss <= '9')) {
                char es = s.charAt(end);
                if ((es >= 'a' && es <= 'z') || (es >= '0' && es <= '9')) {
                    if (ss != es) return false;
                    start++;
                    end--;
                } else {
                    end--;
                }
            } else {
                start++;
            }
        }
        return true;
    }
}