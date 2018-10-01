class Solution {
    public int numDecodings(String s) {
        int len = s != null ? s.length() : 0;
        if (len <= 0 || s.charAt(0) == '0') return 0;
        int[] memo = new int[len];
        memo[0] = 1;
        for (int i = 1; i<len; i++) {
            int a = s.charAt(i) != '0' ? memo[i-1] : 0;
            int b = 0;
            
            if (s.charAt(i-1) == '1' ||
                s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                if (i-2 >= 0) {
                    b = memo[i-2];
                } else {
                    b = 1;
                }
            }
            memo[i] = a+b;
        }
        return memo[len-1];
    }
}
