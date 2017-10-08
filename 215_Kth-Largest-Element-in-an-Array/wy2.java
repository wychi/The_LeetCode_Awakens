class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, k-1 , 0, nums.length -1);
    }
    
    int findKth(int[] nums, int idx, int head, int tail) {
        int left = head;
        int right = tail;
        
        int pivot = right;
        right--;

        while(left <= right) {
            if(nums[left] < nums[pivot] && nums[right] > nums[pivot]) {
                swap(nums, left, right);
                left++;
                right--;
            }
            if(nums[left] >= nums[pivot]) {
                left++;
            }
            
            if(nums[right] <= nums[pivot]) {
                right--;
            }
        }
        
        swap(nums, left, pivot);
        
        if(left == idx) {
            return nums[left];
        } else if(left > idx) {
            return findKth(nums, idx, head, left-1);
        } else {
            return findKth(nums, idx, left+1, tail);
        }
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
