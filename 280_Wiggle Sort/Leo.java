    public void wiggleSort(int[] nums) {
        boolean aIsLarger = true;
        for (int i = 1; i < nums.length; i++) {
            if (1 == (i&1) ? nums[i-1] <= nums[i] : nums[i-1] >= nums[i]) continue;
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
        }
    }
