class Solution {
	class Solution {
		//Time:O(N^2)
		//Queue:O(N)
    //BFS
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start]) continue;
            visited[start] = true;
            for (int end = start+1; end<=s.length(); end++) {
                if (wordDict.contains(s.substring(start, end))) {
                    queue.offer(end);
                    if (end == s.length()) return true;
                }
            }
        }
        return false;
    }
}
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
        int lastIdx = 0;
        for (int i = 1; i<= s.length() ; i++) {
            for (int j = lastIdx; j<i; j++) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    lastIdx = i;
                    break;
                }
            }
        }
        return result[s.length()];
    }
    
    
}
