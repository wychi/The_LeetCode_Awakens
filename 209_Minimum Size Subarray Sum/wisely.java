class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int f=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if (sum>=s) {
                min=Math.min(min, i-f+1);
                int j=f;
                for (j=f; j<=i; j++) {
                    sum-=nums[j];
                    if (sum>=s) {
                        min=Math.min(min, i-j);
                    } else {
                        f=j+1;
                        break;
                    }
                }
            }
        }
        return f!=0?min:0;
    }
}