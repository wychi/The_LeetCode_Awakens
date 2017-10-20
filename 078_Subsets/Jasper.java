class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> tmp, int index) {
        result.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(result, nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
