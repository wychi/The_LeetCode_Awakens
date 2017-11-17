class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] steps = new int[nums.length];
        steps[0]=1;
        int max=1;
        for (int i=1; i<nums.length; i++) {
            steps[i]=1;
            for (int j=0; j<i; j++) {
                if (nums[i]>nums[j]) {
                    if (steps[j]+1>steps[i]) {
                        steps[i]=steps[j]+1;
                    }
                }
            }
            max=Math.max(max, steps[i]);
        }
        return max;
    }
}