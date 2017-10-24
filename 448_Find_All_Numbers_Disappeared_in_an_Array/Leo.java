class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        for (int i = 0, size = nums.length; i < size; i++) {
            while (nums[i] != i+1) {
                int tempV = nums[i];
                int tempIdx = tempV - 1;
                if (tempV == nums[tempIdx]) break;
                nums[i] = nums[tempIdx];
                nums[tempIdx] = tempV;
            }
        }
        for (int i = 1, size = nums.length; i <= size; i++) {
            if (i != nums[i-1]) ret.add(i);
        }
        return ret;
    }
}
