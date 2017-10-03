class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        
        int count = 0;
        for(int i=0; i<nums.length-1; i++) {
            int p = nums[i] + k;
            
            for(int j=i+1; j<nums.length; j++) {
                if(p == nums[j]) {
                    count++;
                    while(j < nums.length-1 && nums[j] == nums[j+1]) j++;
                } else if(nums[j] > p) {
                    break;
                }
            }
            
            while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
            
        }
        
        return count;
    }
}
