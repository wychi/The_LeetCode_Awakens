class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void subsets(int[] nums, int start, List<Integer> subList, List<List<Integer>> result) {
        result.add(new ArrayList<>(subList));

        for (int i = start; i < nums.length; ++i) {
            subList.add(nums[i]);
            subsets(nums, i + 1, subList, result);
            subList.remove(subList.size() - 1);
        }
    }
}
