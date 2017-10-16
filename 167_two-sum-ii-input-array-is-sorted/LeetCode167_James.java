package com.myleetcode;

public class LeetCode167 {
    public static void main(String[] args) {
        LeetCode167 obj = new LeetCode167();
        int[] index = obj.twoSum(new int[]{-1, 0}, -1);
        if (index == null) {
            System.out.println("NO FOUND");
        } else {
            System.out.printf("%d, %d\n", index[0], index[1]);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
                continue;
            } else if (sum < target) {
                i++;
                continue;
            } else if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}
