package com.myleetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            } else {
                nums[index] *= -1;
            }
        }
        return res;
    }
}
