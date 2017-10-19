class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        long size = (long) Math.pow(2, nums.length);
        for (long i = 0; i < size; i++) {
            List<Integer> temp = new ArrayList<>();
            int start = 0;
            long x = i;
            while (x > 0) {
                if ((x & 0x1) != 0) temp.add(nums[start]);
                x >>= 1;
                start++;
            }
            result.add(temp);
        }
        return result;
    }
}