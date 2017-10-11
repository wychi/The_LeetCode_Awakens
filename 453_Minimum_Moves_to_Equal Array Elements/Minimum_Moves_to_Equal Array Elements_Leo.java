class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int v:nums) {
            sum += v;
            if (min > v) min = v;
        }
        return sum - (min*nums.length);
    }
}
