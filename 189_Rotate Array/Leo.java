    private void reverse(int[] nums, int l, int h) {
        while (l < h) {
            int temp = nums[l];
            nums[l++] = nums[h];
            nums[h--] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (k > len) k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k -1 );
        reverse(nums, k, len - 1);
    }
