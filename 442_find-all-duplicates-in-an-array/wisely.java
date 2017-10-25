class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) num = Math.abs(num);
            int index = num - 1;
            if (nums[index] < 0) {
                result.add(num);
            } else {
                nums[index] *= -1;
            }
        }
        return result;
    }
}