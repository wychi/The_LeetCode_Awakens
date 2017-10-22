class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] ret = new int[size];
        int f = 1;
        for (int i = 0; i < size; i++) {
            ret[i] = f;
            f *= nums[i];
        }
        f = 1;
        for (int i = size-1; i >= 0; i--) {
            ret[i] *= f;
            f *= nums[i];
        }
        return ret;
    }
}
