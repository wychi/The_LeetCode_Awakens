class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        bt(nums, 0, new ArrayList<Integer>(), results);
        
        return results;
    }
    
    void bt(int[] nums, int idx, List<Integer> sol, List<List<Integer>> results) {
        if(idx == nums.length) {
            results.add(new ArrayList<Integer>(sol));
            return;
        }
        
        bt(nums, idx+1, sol, results);
        
        sol.add(nums[idx]);
        bt(nums, idx+1, sol, results);
        sol.remove(sol.size() - 1);
    }
}
