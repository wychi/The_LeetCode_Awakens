class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i<candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, target-candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}