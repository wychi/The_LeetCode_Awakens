class Solution {
    /**
    For a sequence of numbers,
    cnt[k] is total number of longest subsequence ending with nums[k];
    len[k] is the length of longest subsequence ending with nums[k];
     */
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        if(n == 0)
            return 0;
        
        int maxlen = 1;
        int[] len = new int[n];
        int[] counts = new int[n];
        counts[0] = 1;
        len[0] = 1;
        
        for(int i=1; i<n; i++) {
            len[i] = 1;
            counts[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        counts[i] = counts[j];
                    } else if(len[j] + 1 == len[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            maxlen = Math.max(maxlen, len[i]);
        }
        
        
        int ans = 0;
        for (int i = 0; i < n; i++) 
            if (len[i] == maxlen) ans += counts[i];
        
        return ans;
    }
}
