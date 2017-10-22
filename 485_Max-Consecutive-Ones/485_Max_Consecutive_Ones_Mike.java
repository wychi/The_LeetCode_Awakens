class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0, consecutiveOne=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 1) {
                consecutiveOne++;
            } else {
                consecutiveOne = 0;
            }
            
            if (consecutiveOne > max) {
                max = consecutiveOne;
            }
        }
        return max;
    }
}