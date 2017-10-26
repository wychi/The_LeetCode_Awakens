package com.myleetcode;

import com.myleetcode.util.Utils;

import java.util.Arrays;

public class LeetCode034 {
    public static void main(String[] args) {
        // write your code here
        int[] nums = new int[]{1};
        LeetCode034 obj = new LeetCode034();
        int[] res = obj.searchRange(nums, 1);
        Utils.printIntArray(res);
    }


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int index = Arrays.binarySearch(nums, 0, nums.length, target);
        System.out.println(index);
        if (index >= 0) {
            int i = index;
            while (i >= 0) {
                if (nums[i] == target) {
                    i--;
                } else {
                    break;
                }
            }
            i++;
            int j = index;
            while (j < nums.length) {
                if (nums[j] == target) {
                    j++;
                } else {
                    break;
                }
            }
            j--;
            return new int[]{i, j};
        } else {
            return new int[]{-1, -1};
        }
    }
}
