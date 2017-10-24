class Solution {
    //Key:
    //1. negative each number
    //Time: O(N)
    //Space:O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int idx = 0;
        for (int i = 0 ; i< nums.length; i++) {
            idx = Math.abs(nums[i]);
            if (nums[idx-1] > 0)
                nums[idx-1] = -nums[idx-1];
        }
        for (int i = 0 ; i<nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
