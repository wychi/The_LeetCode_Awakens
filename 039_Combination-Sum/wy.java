class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        List<List<Integer>> results = new ArrayList<>();
        findCombination(candidates, target, 0, new ArrayList<>(), results);
        
        return results;
    }
    
    private void findCombination(int[] candidates, int target, int sIdx, List<Integer> sol, List<List<Integer>> results) {
        if(target == 0) {
            results.add(new ArrayList(sol));
            return;
        }
        
        for(int i = sIdx; i<candidates.length; i++) {
            int c = candidates[i];
            if(c > target) {
                return;
            }
            
            sol.add(c);
            findCombination(candidates, target - c, i, sol, results);
            sol.remove(sol.size()-1);
            
        }
    }
}
