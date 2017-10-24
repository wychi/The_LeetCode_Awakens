package com.myleetcode;

import com.myleetcode.util.Utils;

import java.util.Arrays;

public class LeetCode324 {
    public static void main(String[] args) {
        //1, 5, 1, 1, 6, 4
        //1, 1, 2, 1, 2, 2, 1
        int[] a = new int[]{1, 1, 2, 1, 2, 2, 1};
        LeetCode324 obj = new LeetCode324();
        obj.wiggleSort(a);
        Utils.printIntArray(a);
    }

    public void wiggleSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int i = (arr.length % 2 == 0) ? (arr.length / 2) - 1 : arr.length / 2;
        int j = arr.length - 1;
        int index = 0;
        while (index < arr.length) {
            boolean even = (index % 2 == 0);
            if (even) {
                nums[index] = arr[i];
                i--;
            } else {
                nums[index] = arr[j];
                j--;
            }
            index++;
        }
    }
}
