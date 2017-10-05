package com.myleetcode;

import java.util.HashMap;
import java.util.Map;


/**
 * @See https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 * */
public class LeetCode532 {
    public static void main(String[] args) {
        LeetCode532 obj = new LeetCode532();
        System.out.println(Integer.toString(obj.findPairs(new int[]{3, 1, 4, 1, 5}, 2)));
        System.out.println(Integer.toString(obj.findPairs(new int[]{1, 2, 3, 4, 5}, 1)));
        System.out.println(Integer.toString(obj.findPairs(new int[]{1, 3, 1, 5, 4}, 0)));
    }

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}
