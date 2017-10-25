class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int value = Math.abs(nums[i]);
            if (nums[value - 1] > 0) {
                nums[value - 1] = -nums[value - 1];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
