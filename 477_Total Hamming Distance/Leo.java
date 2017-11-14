class Solution {
    public int totalHammingDistance(int[] nums) {
        int ret = 0, len = nums.length;
        for (int mask = 1; mask != 0; mask <<= 1) {
            int count = 0;
            for (int v:nums) {
                if ((v&mask) !=0) count++;
            }
            ret += count*(len-count);
        }
        return ret;
    }
}
