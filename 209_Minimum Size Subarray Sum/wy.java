class Solution {
/**
7
[2,3,1,2,4,3]
4
[1,4,4]
11
[1,2,3,4,5]
*/
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        boolean found = false;
        while(right < nums.length) {
            sum += nums[right];
            right++;
            
            while(sum - nums[left] >= s) {
                sum -= nums[left];
                left++;
            }
            if(sum >= s) {
                found = true;
                min = Math.min(min, right - left);
            }
                
        }

        return found ? min : 0;
    }
}
