public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0, write = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (write != i) {
                    nums[write] = nums[i];
                    nums[i] = 0;    
                }
                write++;
            }
        }  
    }
}
