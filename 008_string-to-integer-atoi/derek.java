class Solution {
    public int myAtoi(String str) {
        if (null == str || str.length() <= 0) {
            return 0;
        }
        int i = 0;
        long result = 0;
        int sign = 1;
        str = str.trim();
        if (str.length() <= 0) return 0;
        if (str.charAt(i) == '+') {
            i++;
            sign = 1;
        } else if (str.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        for (int j = i; j<str.length() ; j++) {
            if (!isValidNumber(str.charAt(j))) {
                return (int) result * sign;
            }
            result = result * 10 + str.charAt(j) - '0';
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && (-1)* result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) result * sign;
        
    }
    
    private boolean isValidNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
