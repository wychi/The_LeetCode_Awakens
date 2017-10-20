package com.myleetcode;

import java.util.Arrays;

public class LeetCode698 {
    public static void main(String[] args) {
        // write your code here
        LeetCode698 obj = new LeetCode698();
        System.out.println(obj.canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            System.out.println("#18");
            return false;
        }

        int avg = sum / k;
        for (int n : nums) {
            if (n > avg) {
                System.out.println("#25");
                return false;
            }
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        while (k > 0) {
            boolean b = find(nums, avg, used);
            if (!b) {
                return false;
            } else {
                k--;
            }
        }
        return true;
    }

    private boolean find(int[] nums, int target, boolean[] used) {
        if (target == 0) {
            return true;
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (used[i]) {
                continue;
            } else {
                if (target - nums[i] >= 0) {
                    used[i] = true;
                    if (find(nums, target - nums[i], used)) {
                        return true;
                    } else {
                        used[i] = false;
                    }
                }
            }
        }
        return false;
    }
}
