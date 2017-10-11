class Solution {
    public int minMoves2(int[] nums) {
        final int len = null != nums? nums.length: 0;
        if (len <= 0 ) return 0;
        Arrays.sort(nums);//O(NlogN)
        int result = 0;
        int i = 0, j = len-1;
        final int midNum = nums[len/2];
        while (i<j) {
            result += (midNum - nums[i++]);
            result += (nums[j--] - midNum);
        }
        return result;
    }
}
