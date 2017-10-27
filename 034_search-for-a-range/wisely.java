class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        return get(nums, target, 0, nums.length-1);
    }
    
    private int[] get(int[] nums, int target, int s, int e) {
        if (nums[s] < target) s++;
        if (nums[e] > target) e--;
        if (s > e) return new int [] {-1, -1};
        if (s == e && nums[s] != target) return new int [] {-1, -1};
        if (nums[s] == target && nums[e] == target) return new int [] {s, e};
        int m = s + ((e-s) / 2);
        int[] left = (nums[s] <= target && nums[m] >= target) ? get(nums, target, s, m) : new int[] {-1, -1};
        int[] right = (nums[m+1] <= target && nums[e] >= target) ? get(nums, target, m+1, e) : new int[] {-1, -1};
        if (left[0] == -1 && left[1] == -1) return right;
        if (right[0] == -1 && right[1] == -1) return left;
        return new int[]{left[0], right[1]};
    }
}