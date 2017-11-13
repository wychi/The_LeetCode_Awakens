class Solution {
/**
s1 = sub1 + e1
s2 = sub2 + e2

f(s1, s2) = f(sub1, sub2) + 1 
    max( f(sub1, s2) or f(s1, sub2) )
   */ 
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
    
        for(int i=0;i<n1;i++) {
            for(int j=0;j<n2;j++) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max( dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        int val = dp[n1][n2];
        
        
        return n1-val + n2-val;
    }
}
