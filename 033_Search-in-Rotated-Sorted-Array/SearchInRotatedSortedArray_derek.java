/**
 * Author: Derek Lai
 * Question 1: Empty array ?
 * Question 2: DESC ? ASEC ?
 *
 * Time: O(log n)
 * Space:O(1)
 */
public class Solution {
class Solution {
    // public int search(int[] nums, int target) {
    //     int lo = 0, hi = nums.length - 1;
    //     while (lo <= hi) {
    //         int mid = lo + (hi - lo) / 2;
    //         int num = (nums[mid] < nums[0]) == (target < nums[0])
    //             ? nums[mid]
    //             : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    //         if (num > target) {
    //             hi = mid - 1;
    //         } else if (num < target) {
    //             lo = mid + 1;
    //         } else {
    //             return mid;
    //         }
    //     }
    //     return -1;
    // }
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= nums[hi]) { // right side
                if (target > nums[mid] && target <= nums[hi]) { //target is between mid ~ end
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            } else {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid-1;
                } else {
                    lo = mid+1;
                }
            }
        }
        return -1;
    }
}

    /**
     * Solution:Binary Search v2
     * Time: O(log n)
     * Space:
     *
     * Runtime: 13 ms
     */
    public int search(int[] nums, int target) {
        final int length = null != nums ? nums.length : 0;
        if (length <= 0) {
            return -1;
        }
        
        // Find the smallest index
        int start = 0, end = length -1;
        int minIdx = 0;
        while (start < end) {
            minIdx = start + (end - start) / 2;
            if (nums[minIdx] > nums[end]) {
                start = minIdx + 1;
            } else {
                end = minIdx;
            }
        }
        minIdx = start;
        
        start = target <= nums[length - 1] ? minIdx : 0;
        end = target > nums[length - 1] ? minIdx : length - 1;
        while (start <= end) {
            minIdx = start + (end - start) / 2;
            if (nums[minIdx] == target) {
                return minIdx;
            } else if (nums[minIdx] > target) {
                end = minIdx - 1 ;
            } else {
                start = minIdx + 1;
            }
        }
        
        return -1;
    }
    
    /**
     * Solution:Binary Search v1
     * Time: O(log n)
     * Space:
     *
     * Runtime: 21 ms
     */
    // public int search(int[] nums, int target) {
    //     final int length = null != nums ? nums.length : 0;
    //     if (length <= 0) {
    //         return -1;
    //     }
    
    //     //Find the lowest index
    //     int start = 0, end = length-1;
    //     int midIdx = 0;
    //     while (start < end) {
    //         midIdx = (start+end) / 2;
    //         if (nums[midIdx] > nums[end]) {
    //             start = midIdx + 1;
    //         } else {
    //             end = midIdx;
    //         }
    //     }
    
    //     //if start == end, that is rotated index
    //     int rotatedIdx = start;
    //     int realMidIdx = 0;
    
    //     start = 0;
    //     end = length-1;
    //     while (start <= end) {
    //         midIdx = (start+end) / 2;
    //         realMidIdx = (midIdx+rotatedIdx) % length;
    //         if (nums[realMidIdx] == target) {
    //             return realMidIdx;
    //         } else if (nums[realMidIdx] < target) {
    //             start = midIdx + 1;
    //         } else {
    //             end = midIdx - 1;
    //         }
    //     }
    
    //     return -1;
    // }
    
    /**
     * Solution: Iterator
     * Time: O(n)
     * Space:O(1)
     *
     * Runtime: 18 ms
     */
    // public int search(int[] nums, int target) {
    //     final int length = null != nums ? nums.length : 0;
    //     if (length <= 0) {
    //         return -1;
    //     }
    
    //     int n = -1;
    //     if (nums[0] == target) {
    //         return 0;
    //     } else if (nums[0] > target) {
    //         //reverse
    //         for (int i=length-1; i>=0; i--) {
    //             if (nums[i] == target) {
    //                 return i;
    //             }
    //         }
    //     } else {
    //         for (int i = 0 ; i< length; i++) {
    //             if (nums[i] == target) return i;
    //         }
    //     }
    //     return -1;
    // }
}
