class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int count = 0;
        while (start < end) {
            count = count + nums[end] - nums[start];
            end--;
            start++;
        }
        return count;
    }
}