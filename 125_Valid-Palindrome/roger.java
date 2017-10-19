class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();

        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char ch1 = s.charAt(i), ch2 = s.charAt(j);

            if (!isValid(ch1)) {
                i++;

            } else if (!isValid(ch2)) {
                j--;

            } else if (ch1 == ch2) {
                i++;
                j--;

            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
