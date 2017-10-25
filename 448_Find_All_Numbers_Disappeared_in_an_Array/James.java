package com.myleetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode448 {
    public static void main(String[] args) {
        LeetCode448 obj = new LeetCode448();
        //4,3,2,7,8,2,3,1
        List<Integer> list = obj.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for (int n : list) {
            System.out.println("" + n + ", ");
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int count = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
                count--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length && count > 0; ++i) {
            if (nums[i] > 0) {
                count--;
                res.add(i + 1);
            }
        }
        return res;
    }
}
