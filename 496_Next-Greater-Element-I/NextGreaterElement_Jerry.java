class Solution {

    // Totally time: O(N) *important: push/pop stack for only N times
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        for (int n: nums2) {
            while(!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        
        // Test nums1 array
        for(int i=0; i< nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                nums1[i] = map.get(nums1[i]);
            } else {
                nums1[i] = -1;
            }
        }
        
        return nums1;
    }

    // Totally time: O(N^2)
    public int[] nextGreaterElement_old(int[] nums1, int[] nums2) {
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