package com.myleetcode;

public class LeetCode485 {
    public static void main(String[] args) {
        LeetCode485 obj = new LeetCode485();
        int len = obj.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println("len = " + len);
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int n : nums) {
            if (n != 0) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
