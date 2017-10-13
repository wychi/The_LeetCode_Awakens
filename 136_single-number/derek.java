class Solution {
    //Key:
    //1. Need to scan to the end so that know only once or not.
    //2. Use xor
    //Time: O(N)
    //Space:O(1)
    public int singleNumber(int[] nums) {
        final int len = null != nums ? nums.length : 0;
        if (len <= 0) {
            return 0;
        }
        
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
