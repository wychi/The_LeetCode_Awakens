class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        final int size = null != nums ? nums.length: 0;
        if (size <= 0) {
            return 0;
        }
        
        int count=0, max = 0;
        for (int i = 0 ;i<size; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
