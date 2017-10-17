class Solution {
    //Method 1:
    //1. Reverse, reverse
    //2. Swap via XOR
    // Question:
    // Is K larger than nums.length ? how to handle ?
    
    //Time:  O(N)
    //Space: O(1)
    public void rotate(int[] nums, int k) {
        final int len = null != nums ? nums.length : 0;
        k %= len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        // int temp = 0;
        // while (start < end) {
        //     temp = nums[start];
        //     nums[start] = nums[end];
        //     nums[end] = temp;
        //     start++;
        //     end--;
        // }
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }
}
