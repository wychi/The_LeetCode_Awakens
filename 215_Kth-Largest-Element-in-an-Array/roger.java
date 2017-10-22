class Solution {
    public int findKthLargest(int[] nums, int k) {
        return nums[findKthSmallest(nums, 0, nums.length - 1, nums.length - k + 1)];
    }

    public int findKthSmallest(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int pIdx = start;

        for (int i = start; i < end; ++i) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIdx++);
            }
        }
        swap(nums, pIdx, end);

        int m = pIdx - start + 1;
        if (m == k) {
            return pIdx;
        } else if (m < k) {
            return findKthSmallest(nums, pIdx + 1, end, k - m);
        } else {
            return findKthSmallest(nums, start, pIdx - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
