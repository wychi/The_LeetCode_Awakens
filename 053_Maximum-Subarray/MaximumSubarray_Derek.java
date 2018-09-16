//Time:O(N)
//Space:O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i<nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

public class Solution {
  public int maxSubArray(int[] nums) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0) {
	  return 0;
	}
	int maxSoFar= nums[0], maxValue = nums[0];
	for (int i = 1; i<len; i++) {
	  maxValue = Math.max(maxValue+nums[i], nums[i]);
	  maxSoFar = Math.max(maxSoFar, maxValue);
	}
	return maxSoFar;
  }
}
