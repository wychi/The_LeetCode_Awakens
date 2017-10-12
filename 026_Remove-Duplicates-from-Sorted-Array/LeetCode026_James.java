package com.myleetcode;

public class LeetCode026 {
    public static void main(String[] args) {
        // write your code here
        LeetCode026 obj = new LeetCode026();
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 2, 2, 5}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 2) {
            return (nums == null) ? 0 : nums.length;
        }
        int j = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

}
