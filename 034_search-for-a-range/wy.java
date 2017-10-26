class Solution {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    int[] binarySearch(int[] nums, int target, int start, int end) {
        if(start > end) {
            return new int[] {-1, -1};
        }
        
        int[] range = new int[] {-1, -1};
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
            range[0] = mid;
            range[1] = mid;
            int[] left = binarySearch(nums, target, start, mid-1);
            int[] right = binarySearch(nums, target, mid+1, end);
            if(left[0] != -1) {
                range[0] = left[0];
            }
            if(right[1] != -1)
                range[1] = right[1];
            return range;
        } else if(nums[mid] > target) {
            return binarySearch(nums, target, start, mid-1);
        } else {
            return binarySearch(nums, target, mid+1, end);
        }
    }
}
