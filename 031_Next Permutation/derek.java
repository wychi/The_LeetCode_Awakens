//Time:O(N)
//Space:O(1)
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        //find decreament from right to left
        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        
        if (i>=0) {
            //Found
            int j = nums.length-1;
            while (j>=0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    private void reverse(int[] nums, int i) {
        int start = i, end = nums.length-1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
