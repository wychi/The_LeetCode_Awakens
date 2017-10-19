class Solution {
    
    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break; //
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1; //speed up
        if (nums[row] > target) return false;
        //speed up
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }
    
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int sum = 0;
//         for (int num:nums) sum += num;
//         if (k <= 0 || sum%k != 0) return false;
//         boolean[] visited = new boolean[nums.length];
//         return canPartition(nums, visited, 0, k, 0, sum/k);
//     }
    
//     public boolean canPartition(int[] nums, boolean[] visited, int start_index, int k, int cur_sum, int target){
//         if (k == 1) return true;
//         if (cur_sum > target) return false; // cut
//         if (cur_sum == target)
//             return canPartition(nums, visited, 0, k-1, 0, target);
//         for (int i = start_index; i<nums.length; i++) {
//             if(!visited[i]) {
//                 visited[i] = true;
//                 if (canPartition(nums, visited, i+1, k, cur_sum + nums[i], target))
//                     return true;
//                 visited[i] = false;
//             }
//         }
//         return false;
//     }
}
