class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        
        int ret = 1;
        int[] len = new int[n];
        len[0] = 1;
        for(int i=1; i<n; i++) {
            len[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    len[i] = Math.max(len[i], len[j] + 1);
                }
            }
            ret = Math.max(ret, len[i]);
        }
        
        return ret;
    }
}
