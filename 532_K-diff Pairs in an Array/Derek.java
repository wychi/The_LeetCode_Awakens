class Solution {
    public int findPairs(int[] nums, int k) {
        if (null == nums || nums.length < 0 || k < 0) {
            return 0;
        }
        
        int count = 0;
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        //Count unique number
        for (int n : nums) {
            Integer val = resultMap.get(n);
            if (null == val) {
                resultMap.put(n, 1);
            } else {
                resultMap.put(n, val.intValue()+1);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry: resultMap.entrySet()) {
            if (0 == k) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (resultMap.containsKey(entry.getKey()+k)) {
                    count++;
                }
            }
        }
        return count;
    }
}