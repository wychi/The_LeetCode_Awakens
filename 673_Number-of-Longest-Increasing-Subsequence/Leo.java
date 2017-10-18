class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length <=0 ) return 0;
        int maxLen = 1, size = nums.length, ret = 0;
        int[] length = new int[size], counts = new int[size];
        counts[0] = 1;
        for (int i = 0; i < size; i++) {//1,3,5,4,7
            int len = 0, cnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) continue;
                if (len < length[j]) {
                    len = length[j];
                    cnt = counts[j];
                } else if (len == length[j]) {
                    cnt += counts[j];
                }
            }
            length[i] = ++len;
            counts[i] = cnt;
            if (len > maxLen) maxLen = len;
        }
        for (int i = 0; i < size; i++) {
            if (length[i] == maxLen) ret +=counts[i];
        }
        return ret;
    }
}
