class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int fast = -1, len = nums.length, sum = 0;
        int ret = len;
        for (int i = 0; i < len; i++) {
            while (sum < s && ++fast < len) sum += nums[fast];
            if (sum < s) break;
            ret = Math.min(fast-i, ret);
            sum -= nums[i];
        }
        return ret == len ? 0 : ret+1;
    }
}
