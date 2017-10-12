class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0, size = nums.length;
        if (size == 0) return 0;
        for (int i = 1; i < size; i++) {
            if (nums[pos] != nums[i]) nums[++pos] = nums[i];
        }
        return pos+1;
    }
}
