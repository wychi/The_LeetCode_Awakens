class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        HashSet<Integer> numSet = new HashSet<>();
        Integer lastMatch = null;
        for(int i=0;i<nums.length;i++) {
            
            if(lastMatch!=null && lastMatch == nums[i]) { //Skip duplicate pair
                continue;
            }
            
            lastMatch = null;
            
            if(numSet.contains(nums[i]-k)) {
                count++; 
                lastMatch = nums[i];
            }
            
            numSet.add(nums[i]);
        }
        return count;
    }
}