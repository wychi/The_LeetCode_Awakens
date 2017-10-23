class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int tmp = 1;
        for(int i=0;i<n; i++) {
            result[i] = tmp;
            tmp = tmp * nums[i];
        }
        
        tmp = 1;
        for(int i=n-1;i>=0; i--) {
            result[i] = result[i] * tmp;
            tmp = tmp * nums[i];
        }
        
        return result;
    }
}
