class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        
        int prevSize = 0;
        for(int i=0;i<nums.length;i++) {
            int size = results.size();
            
            
            int j = 0;
            if(i>0 && nums[i] == nums[i-1])
                j = prevSize;
            prevSize = size;
            for(;j<size; j++) {
                ArrayList<Integer> clone = new ArrayList<>(results.get(j));
                clone.add(nums[i]);
                results.add(clone);
            }
            
            prevSize = size;

        }
        
        return results;
        
    }
}
