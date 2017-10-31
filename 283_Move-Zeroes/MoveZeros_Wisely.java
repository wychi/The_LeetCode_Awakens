class Solution {
    public void moveZeroes(int[] nums) {
        int n = 0;
        for (int num : nums) {
            if (num!=0) {
                nums[n] = num;
                n++;
            }
        }
        for (int i=n; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
    
    /*public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int f = 0, l = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] == 0) {
                f = i;
                for (l=f+1; l<n; l++) {
                    if (nums[l] != 0) {
                        swap(nums, f, l);
                        f=l;
                        break;
                    }
                }
                if (l==n) return;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }*/
}