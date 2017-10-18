class Solution {
    
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len -1);
    }
    
    private void reverse(int[] nums, int low, int high) {
        
        while(low<high) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }        
    }
}