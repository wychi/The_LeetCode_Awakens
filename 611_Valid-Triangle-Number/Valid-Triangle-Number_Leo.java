class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = nums.length-1; i >= 2; i--) {
            int l = 0, r = i-1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ret += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ret;
    }
}
