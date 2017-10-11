package com.myleetcode;

//TODO
public class LeetCode215 {
    public static void main(String[] args) {
        LeetCode215 obj = new LeetCode215();
        System.out.println("ans = " + obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        // write your code here
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickselect(int[] nums, int start, int end, int k) {
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot)
                swap(nums, left++, i);
        }
        swap(nums, left, end);

        if (left == k)
            return nums[left];
        else if (left < k)
            return quickselect(nums, left + 1, end, k);
        else
            return quickselect(nums, start, left - 1, k);
    }

    public void swap(int[] nums, final int i, final int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
