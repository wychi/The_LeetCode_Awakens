package com.myleetcode;

public class LeetCode136 {
    public static void main(String[] args) {
        // write your code here
        LeetCode136 obj = new LeetCode136();
        System.out.println("" + obj.singleNumber(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
