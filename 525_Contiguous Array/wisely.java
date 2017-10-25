class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        maps.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            sum += (nums[i] == 0 ? -1 : 1);
            if (maps.containsKey(sum)) {
                max = Math.max(max, i-maps.get(sum));
            } else {
                maps.put(sum, i);
            }
        }
        return max;
    }
}