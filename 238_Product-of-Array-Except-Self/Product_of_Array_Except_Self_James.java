package com.myleetcode;

import com.myleetcode.util.Utils;

import java.util.Arrays;

public class LeetCode238 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        LeetCode238 obj = new LeetCode238();
        obj.productExceptSelf(arr);
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
