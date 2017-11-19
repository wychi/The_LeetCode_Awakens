class Solution {
    //Key:
    //1. dp, same as longest common subsequence
    //Use longest common subsequence
    //Time: O(MN)
    //Space: O(MN)
    public int minDistance(String word1, String word2) {
        final int len1 = null != word1 ? word1.length() : 0;
        final int len2 = null != word2 ? word2.length() : 0;
        
        int[][] dp = new int[len1+1][len2+1];
        
        for (int row = 1; row<=len1; row++) {
            for (int col = 1; col<=len2; col++) {
                if (word1.charAt(row-1) == word2.charAt(col-1)) {
                    dp[row][col] = dp[row-1][col-1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }
        int val = dp[len1][len2];
        return len1-val + len2-val;
    }
}
