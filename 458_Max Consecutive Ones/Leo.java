class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0, current = 0;
        for (int v: nums) {
            if (v == 0) {
                current = 0;
            } else {
                if (ret < ++current) ret = current;
            }
        }
        return ret;
    }
}
