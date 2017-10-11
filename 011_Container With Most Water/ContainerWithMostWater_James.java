package com.myleetcode;

public class LeetCode011 {
    public static void main(String[] args) {
        LeetCode011 obj = new LeetCode011();
        System.out.println("maxArea = " + obj.maxArea(new int[]{1, 2}));
    }

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        if (height == null || height.length < 2) {
            return 0;
        }
        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * Math.abs(start - end));
            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxArea;

    }
}
