class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0) nums[index] *= -1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}