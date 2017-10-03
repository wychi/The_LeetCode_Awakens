public class Solution {
    private void combinationSum(int[] candidates, int startIndex, int target, LinkedList<Integer> container,
                                   LinkedList<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new LinkedList<>(container));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int v = candidates[i];
            if (v > target) break;
            container.add(v);
            combinationSum(candidates, i, target - v, container, ret);
            container.removeLast();
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> ret = new LinkedList<>();
        combinationSum(candidates, 0, target, new LinkedList<Integer>(), ret);
        return ret;
    }
}
