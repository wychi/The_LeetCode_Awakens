class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int count = 1;
        int current = nums[0];
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] != current) {
                nums[count] = nums[i];
                count++;
                current = nums[i];
            }
        }
        return count;
    }
}
