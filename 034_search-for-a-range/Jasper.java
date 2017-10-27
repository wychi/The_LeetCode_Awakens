class Solution {
    public int[] searchRange(int[] nums, int target) {
                int lo = 0;
        
        if(nums.length == 0) {
            return new int[] {-1,-1};
        }
        
        int hi = nums.length - 1;
        int mid = 0;    
        boolean found = false;
        
        int[] result = new int[2];

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        if(nums[lo] != target) {
            Arrays.fill(result, -1);
            return result;
        }
        
        result[0] = lo;
        
        hi = nums.length - 1;
        
        while(lo < hi) {
            mid = hi - (hi-lo) / 2;
            if(nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }                        
        }
        result[1] = hi;
                
        return result;

    }
}