class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        
        Map<Integer, Integer> uniqueMap = new HashMap<>();
        for (int n: nums) {
            uniqueMap.put(n, uniqueMap.getOrDefault(n, 0)+1);
        }
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: uniqueMap.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (uniqueMap.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}