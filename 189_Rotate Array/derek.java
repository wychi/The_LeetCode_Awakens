class Solution {
    //Method 1:
    //1. Reverse, reverse
    //2. Swap via XOR
    // Question:
    // Is K larger than nums.length ? how to handle ?
    
    //Time:  O(N)
    //Space: O(1)
    public void rotate(int[] nums, int k) {
        final int len = null != nums ? nums.length : 0;
        k %= len;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        // int temp = 0;
        // while (start < end) {
        //     temp = nums[start];
        //     nums[start] = nums[end];
        //     nums[end] = temp;
        //     start++;
        //     end--;
        // }
        while (start < end) {
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }
}
class Solution {
    //Method 1: reverse array
    //Time: O(N), N is array length
    //Space:O(1)
//     public void rotate(int[] nums, int k) {
//         int step = k % nums.length;
//         reverse(nums, 0, nums.length-1);
//         reverse(nums, 0, step-1);
//         reverse(nums, step, nums.length-1);
//     }
    
//     private void reverse(int[] nums, int i, int j) {
//         int temp;
//         while (i < j) {
//             temp = nums[j];
//             nums[j] = nums[i];
//             nums[i] = temp;
//             i++;
//             j--;
//         }
//     }
    //Method2: concate array
    //Time: O(N)
    //Space: O(N)
//     public void rotate(int[] nums, int k) {
//         int[] nums2 = new int[2*nums.length];
//         for (int i = 0; i<nums2.length; i++) {
//             if (i >= nums.length) {
//                 nums2[i] = nums[i-nums.length];
//             } else {
//                 nums2[i] = nums[i];
//             }
//         }
        
//         int step = k % nums.length;
//         int head = nums.length-step;
//         int i = 0;
//         while (head < nums2.length && i < nums.length) {
//             nums[i++] = nums2[head++];
//         }
//     }
    //Method3: use extry array
    //Time: O(N)
    //Space:O(N)
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0 ;i< nums.length; i++) {
            a[(i+k) % nums.length] = nums[i];
        }
        for (int i = 0 ; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
