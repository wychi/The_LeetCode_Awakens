class Solution {
    
           
    Integer maxLen = 0;
    Integer maxCount = 0;
    boolean[] visited;
    HashSet<Integer> nodesInLongestSeq = new HashSet<>();
        
    public int findNumberOfLIS(int[] nums) {
        
        if(nums.length == 0) {
            return 0;
        }
        
        visited = new boolean[nums.length];
        HashSet<Integer> nodes = new HashSet<>();
        backtrack(0, nums, -1, nodes);
        return maxCount;
    }
    
    private void backtrack(int len, int[] nums, int start, HashSet<Integer> nodes) {

        if(len > maxLen) {
            maxLen = len;
            maxCount = 1;
            nodesInLongestSeq = nodes;
        } else if(len == maxLen) {
            maxCount++;
            nodesInLongestSeq.addAll(nodes);
        }
        
        for(int i = start+1;i<nums.length;i++) {
            
            if(nodesInLongestSeq.contains(i)) {
                return;
            }
            
            if(len == 0 || (nums[i] > nums[start] && ((nums.length - i) + len >= maxLen))) {
                nodes.add(i);
                backtrack(++len, nums, i, nodes);
                len--;
                nodes.remove(i);
            }
        }
    
    }
}