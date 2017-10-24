class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int count = len;
        int v;
        for(int i=0;i<len;i++) {
            v = Math.abs(nums[i]) - 1;
            if (nums[v] > 0) {
                nums[v] *= -1;
            }
        }

        List<Integer> resultList = new ArrayList();
        for(int i=0;i<len;i++) {
            if (nums[i] > 0) {
                resultList.add(i+1);
            }
        }
        return resultList;
    }
}
