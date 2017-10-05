package com.myleetcode;

public class LeetCode413 {
    public static void main(String[] args) {
        LeetCode413 obj = new LeetCode413();
        System.out.println("size = " + obj.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int len = 0;
        int result = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                len++;
                System.out.printf("%d - %d == %d - %d\n", A[i - 1], A[i - 2], A[i], A[i - 1]);
                result += len;
            } else {
                len = 0;
            }
        }

        return result;
    }
}
