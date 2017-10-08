class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int maxLen = 1;
        for(int i=0; i<p.length(); i++) {
            
            if(i > 0) {
                int dist = p.charAt(i) - p.charAt(i-1);
                if(dist == 1 || dist == -25) {
                    maxLen++;
                } else {
                    maxLen = 1;
                }
            }
            
            int letter = p.charAt(i) - 'a';
            dp[letter] = Math.max(dp[letter], maxLen);
        }
        
        int sum = 0;
        for(int i=0;i<26;i++) {
            sum += dp[i];
        }
        
        return sum;
    }
}
