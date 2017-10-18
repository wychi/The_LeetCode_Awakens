package com.myleetcode;

import com.myleetcode.util.Utils;

public class LeetCode189 {
    public static void main(String[] args) {
        // write your code here
        LeetCode189 obj = new LeetCode189();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
//        obj.rotate(arr, 3);
        obj.rotate2(arr, 2);
        Utils.printIntArray(arr);
    }

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int newIndex = (i + k) % nums.length;
            result[newIndex] = nums[i];
            System.out.printf("%d -> %d\n", i, newIndex);
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = result[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }


    private void swap(int[] nums, int start, int end) {
        int tmp;

        while (start < end) {
            end = end % nums.length;
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


}
