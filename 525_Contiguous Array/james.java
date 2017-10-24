package com.myleetcode;

import java.util.HashMap;

public class LeetCode525 {
    public static void main(String[] args) {
        //0, 0, 1, 0, 0, 0, 1, 1
        //1, 1, 1, 0, 0, 0
        int[] data = new int[]{0, 0, 1, 0, 0, 0, 1, 1};
        LeetCode525 obj = new LeetCode525();
        System.out.println("" + obj.findMaxLength(data));
    }

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}
