class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++) {
            
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            int target = 0 - nums[i];
            int hi = nums.length -1;

            int lo = i+1;
                        
            while(lo<hi) {
                
                int sum = nums[lo] + nums[hi];
                if(sum == target) {
                    ret.add(Arrays.asList(new Integer[] {nums[i], nums[lo], nums[hi]}));
                    
                    
                    while(lo < hi && nums[lo] == nums[lo+1]) {
                        lo++;
                    }
                                        
                    while(lo < hi && nums[hi] == nums[hi-1]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                                        
                    //Update lo,hi
                } else if(sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
            
        }
        
        return ret;
        
    }
}