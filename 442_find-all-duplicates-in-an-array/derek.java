class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int idx = 0;
        for (int i = 0 ; i<nums.length; i++) {
            idx = Math.abs(nums[i]);
            if (nums[idx-1] > 0) {
                nums[idx-1] = -nums[idx-1];
            } else {
                result.add(idx);
            }
        }
        return result;
    }
}
