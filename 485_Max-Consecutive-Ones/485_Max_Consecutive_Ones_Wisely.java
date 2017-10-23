class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int temp = nums[0];
        int count = temp == 1 ? 1 : 0;
        int max = count;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}