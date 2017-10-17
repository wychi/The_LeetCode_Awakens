class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }

        int remain[] = new int[nums.length - k];
        int i = 0, j = 0;
        for (i = 0; i < nums.length - k; ++i) {
            remain[i] = nums[i];
        }
        
        for (; i < nums.length; ++i) {
            nums[j++] = nums[i];
        }

        i = 0;
        for (; j < nums.length; ++j) {
            nums[j] = remain[i++];
        }
    }
}
