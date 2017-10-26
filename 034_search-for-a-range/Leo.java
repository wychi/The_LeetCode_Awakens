class Solution {
    private int getLargerPos(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = (l+h)>>>1;
            if (nums[mid] > target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = getLargerPos(nums, target-1);
        if (left >= nums.length || nums[left] != target) return new int[] {-1, -1};
        int right = getLargerPos(nums, target)-1;
        return new int[] {left, right};
    }
}
