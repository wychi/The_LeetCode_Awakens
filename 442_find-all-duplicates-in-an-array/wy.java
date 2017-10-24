class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) 
                continue;
            int idx = nums[i] - 1;
            if(idx == i)
                continue;
            if(nums[idx] == nums[i]) {
                nums[i] = 0;
                nums[idx] = 0;
                result.add(idx+1);
            } else {
                if(nums[idx] == 0)
                    swap(nums, idx, i);
                else {
                    swap(nums, idx, i);
                    i--;
                }
            }
        }
        
        return result;
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
