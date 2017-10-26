class Solution {
    //Key:
    //hint: O(log N). -> binary search
    public int[] searchRange(int[] nums, int target) {
        final int len = null != nums ? nums.length : 0;
        if (len <= 0) {
            return new int[]{-1, -1};
        }
        
        int[] result = new int[2];
        int start = 0, end = len-1, idx = -1;
        int mid = 0;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                idx = mid;
            }
            if(nums[mid] >= target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result[0] = idx;
        
        //reset start and end value
        start = 0;
        end = len-1;
        idx = -1;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            if (nums[mid] == target) {
                idx = mid;
            }
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        result[1] = idx;
        return result;
    }
}
