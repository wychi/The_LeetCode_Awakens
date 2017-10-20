class Solution {
    
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        
        for(int i=0;i<nums.length && i<=twoIndex;i++) {
            if(nums[i] == 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
            } else if(nums[i] == 2) {
                swap(nums, twoIndex, i);
                twoIndex --;
                i--; //換過來的可能是0, 這個位置要重檢查一次
            }
        }
        
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
        
}