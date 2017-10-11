package com.myleetcode;

import java.util.*;

public class LeetCode179 {
    public static void main(String[] args) {
        LeetCode179 obj = new LeetCode179();
        System.out.println(obj.largestNumber(new int[]{1, 2}));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            str[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if(str[0].charAt(0) == '0'){
            return Integer.toString(0);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
