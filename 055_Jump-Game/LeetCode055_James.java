package com.myleetcode;

public class LeetCode055 {
    public static void main(String[] args) {
        // write your code here
        LeetCode055 obj = new LeetCode055();
        System.out.println(obj.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(obj.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max < i) return false;
            else max = i + nums[i] > max ? i + nums[i] : max;
        }
        return true;

    }
}
