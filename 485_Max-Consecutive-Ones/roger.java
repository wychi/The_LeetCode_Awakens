class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int end = nums[0] == 1 ? 1 : 0;
        int max = end;

        for (int i = 1; i < nums.length; ++i) {
            end = (nums[i] == 1) ? end + 1 : 0;
            max = Math.max(max, end);
        }
        return max;
    }
}
