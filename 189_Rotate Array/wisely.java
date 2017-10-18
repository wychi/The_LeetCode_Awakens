class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null || nums.length < 2) {
            return nums;
        }
        k %= nums.length;
        if (k <= 0) return nums;
        int[] cp = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i < k) {
                cp[i] = nums[nums.length - k + i];
            } else {
                cp[i] = nums[i - k];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cp[i];
        }
    }
}