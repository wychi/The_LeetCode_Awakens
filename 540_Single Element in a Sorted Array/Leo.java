class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0, h = nums.length-1, mask = ~1;
        while (l < h) {
            int mid = ((l+h)>>1) & mask;
            if (nums[mid] != nums[mid+1]) {
                h = mid;
            } else {
                l = 2 + mid;
            }
        }
        return nums[l];
    }
}
