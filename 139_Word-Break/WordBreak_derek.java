class Solution {
    // Key:
    // Solution: DP
    // Time: O(N^2)
    // Space: O(N) //length of string
    public boolean wordBreak(String s, List<String> wordDict) {
        //Solution 1: DP
        //Solution 2: BFS
        
        if (null == s || s.length() <= 0) {
            return false;
        }
        if (null == wordDict || wordDict.size() <= 0) {
            return false;
        }
        
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        int tempIdx = 0;
        for (int i = 1; i<= s.length() ; i++) {
            for (int j = tempIdx; j<i; j++) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    tempIdx = i;
                    break;
                }
            }
        }
        return result[s.length()];
    }
    
    
}
