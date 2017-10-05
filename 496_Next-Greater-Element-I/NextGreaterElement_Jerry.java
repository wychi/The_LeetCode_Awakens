class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int i=0; i<nums1.length; i++) {
            nums1[i] = searchNext(nums1[i], nums2);
        }
        
        return nums1;
    }
    
    private int searchNext(int target, int nums[]) {
        boolean found = false;
        for (int i=0 ; i < nums.length; i++) {
            if (!found && nums[i] == target) {
                found = true;
            } else if (found && nums[i] > target) {
                return nums[i];
            } 
        }
        return -1;
    }
}