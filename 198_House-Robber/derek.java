//Method: Dynamic Programming
//TIme:O(N)
//Space:O(1)
class Solution {
    public int rob(int[] nums) {
        final int len = null != nums ? nums.length: 0;
        if (len <= 0) return 0;
        else if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i<len; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[len-1];
    }
}


//Method: Array
//TIme:O(N)
//Space:O(1)
class Solution {
    public int rob(int[] nums) {
        final int len = null != nums ? nums.length: 0;
        if (len <=0) return 0;
        int oddSum = 0, evenSum = 0;
        for (int i =0 ; i<nums.length; i++) {
            if (i % 2 == 0) {
                evenSum = Math.max(evenSum+nums[i], oddSum);
            } else {
                oddSum = Math.max(oddSum+nums[i], evenSum);
            }
        }
        return Math.max(evenSum, oddSum);
    }
}

//Method: Dynamic Programming
//Prefer method 1
//TIme:O(N)
//Space:O(1)
class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, currMax = 0;
        int temp;
        for (int x: nums) {
            temp = currMax;
            currMax = Math.max(prevMax+x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
