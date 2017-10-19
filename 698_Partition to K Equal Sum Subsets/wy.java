class Solution {
    /**
    [3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]
5
[4, 3, 2, 3, 5, 2, 1]
4
    */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if(sum % k != 0)
            return false;
        
        int target = sum / k;
        Arrays.sort(nums);
        
        boolean[] taken = new boolean[nums.length];
        for(int i=0;i<k;i++) {
            if(bt(nums, taken, target, 0) == false)
                return false;
        }
        
        return true;
    }
    
    boolean bt(int[] nums, boolean[] taken, int target, int sum) {
        if(target == sum) {
            return true;
        }
        
        if(sum > target)
            return false;
        
        for(int i=nums.length-1;i>=0; i--) {
            if(taken[i])
                continue;
            
            if(sum + nums[i] > target)
                return false;
            
            taken[i] = true;
            boolean ret = bt(nums, taken, target, sum + nums[i]);
            if(ret == true)
                return true;
            taken[i] = false;
        }
        
        return false;
    }
}
