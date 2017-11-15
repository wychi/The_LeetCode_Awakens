class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int bitcount = 0;
            for (int num : nums) {
                bitcount += ((num >> i) & 1);
            }
            total += (bitcount * (nums.length - bitcount));
        }
        return total;
    }
}