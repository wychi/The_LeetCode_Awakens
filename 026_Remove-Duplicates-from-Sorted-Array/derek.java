class Solution {
    //Key: Since it's sorted array, just check previous and current element
    public int removeDuplicates(int[] nums) {
        final int len = null != nums ? nums.length: 0;
        if (len <= 1) {
            return len;
        }
        
        int count = 1, n = 0;
        for (int i = 1; i<len; i++) {
            if (nums[i-1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
