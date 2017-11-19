class Solution {
    //Recursive
    //Time Limit Exceeded
//     public int combinationSum4(int[] nums, int target) {
//         if (0 == target) {
//             return 1;
//         }
        
//         int res = 0;
//         for (int i = 0 ; i<nums.length; i++) {
//             if (target - nums[i] >= 0) {
//                 res += combinationSum4(nums, target - nums[i]);
//             }
//         }
//         return res;
//     }
    
    //Method 2:
    // DP - Top Down
    // Prevent to recompute previous result
    // Time: O(N*K)
    // Space: O(K)
//     private int[] dp;
//     public int combinationSum4(int[] nums, int target) {
//         dp = new int[target+1];
//         Arrays.fill(dp, -1);
//         dp[0] = 1;
//         return helper(nums, target);
//     }
    
//     private int helper(int[] nums, int target) {
//         if (-1 != dp[target]) {
//             return dp[target];
//         }
        
//         int res = 0;
//         for (int i = 0; i<nums.length; i++) {
//             if (target - nums[i] >= 0) {
//                 res += helper(nums, target - nums[i]);
//             }
//         }
//         dp[target] = res;
//         return res;
//     }
    
    //Method 3:
    // DP - Bottom Up
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i<dp.length; i++) {
            for (int j = 0 ; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
