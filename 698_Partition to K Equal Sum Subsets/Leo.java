class Solution {
    private boolean canPartition(int[] nums, boolean[] choose, int k, int start, int current, int target) {
        if (1 == k) return true;
        if (current > target) return false;
        if (target == current) return canPartition(nums, choose, k-1, 0, 0, target);
        for (int i = start; i < nums.length; i++) {
            if (choose[i]) continue;
            choose[i] = true;
            if (canPartition(nums, choose, k, i+1, current+nums[i], target)) return true;
            choose[i] = false;
        }
        return false;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int v:nums) sum+=v;
        if (sum%k != 0) return false;
        boolean[] choose = new boolean[nums.length];
        return canPartition(nums, choose, k, 0, 0, sum/k);
    }
}

class Solution {
    private boolean canPartition(int[] nums, boolean[] choose, int k, int start, int current, int target) {
        if (1 == k) return true;
        if (target == current) return canPartition(nums, choose, k-1, nums.length - 1, 0, target);
        for (int i = start; i >= 0; i--) {
            if (choose[i] || (current + nums[i] > target)) continue;
            choose[i] = true;
            if (canPartition(nums, choose, k, i-1, current+nums[i], target)) return true;
            choose[i] = false;
        }
        return false;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int v:nums) sum+=v;
        if (sum%k != 0) return false;
        boolean[] choose = new boolean[nums.length];
        Arrays.sort(nums);
        return canPartition(nums, choose, k, nums.length - 1, 0, sum/k);
    }
}
