class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        int maxTimes = 0, idx = 0;
        for (int i = 0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], 1+map.get(nums[i]));
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > maxTimes) {
                maxTimes = Math.max(maxTimes, map.get(nums[i]));
                idx = i;
            }
            
        }
        
        return nums[idx];
    }
}
