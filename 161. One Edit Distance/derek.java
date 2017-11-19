public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        final int lenS = null != s ? s.length() : 0;
        final int lenT = null != t ? t.length() : 0;
        if (lenS - lenT > 1 || lenT-lenS > 1) return false;
        
        int[][] dp = new int[lenS+1][lenT+1];
        for (int i = 1; i<=lenS; i++) {
            for (int j = 1; j<=lenT; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int result = dp[lenS][lenT];
        if (lenS > lenT) {
            return result == lenS-1;
        } else {
            return result == lenT-1;
        }
    }
}
