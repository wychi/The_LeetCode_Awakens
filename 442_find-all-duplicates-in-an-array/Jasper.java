class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++) {            
            int countIndex = Math.abs(nums[i]) - 1;
            if(nums[countIndex] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[countIndex] = -nums[countIndex];
            }                                
        }
               
        return res;
    }
}
