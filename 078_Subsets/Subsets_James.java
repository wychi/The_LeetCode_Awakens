package com.myleetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode078 {
    public static void main(String[] args) {
        // write your code here
        LeetCode078 obj = new LeetCode078();
        obj.subsets(new int[]{1, 2, 3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = backtrace(nums, 0, new ArrayList<>(), new ArrayList<>());
        System.out.println("list.size = " + list.size());
        for (List<Integer> subList : list) {
            for (int n : subList) {
                System.out.printf("%d, ", n);
            }
            System.out.println();
        }
        return list;
    }

    private List<List<Integer>> backtrace(int[] nums, int index, List<List<Integer>> res, List<Integer> selected) {
        if (index == nums.length) {
            res.add(new ArrayList(selected));
            return res;
        }
        int i = nums[index];
        selected.add(i);
        backtrace(nums, index + 1, res, selected);
        selected.remove(selected.size() - 1);
        backtrace(nums, index + 1, res, selected);
        return res;
    }

}
