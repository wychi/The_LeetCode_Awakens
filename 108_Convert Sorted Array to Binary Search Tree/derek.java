/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        final int len = null != nums ? nums.length : 0;
        if (len <= 0) return null;
        return helper(nums, 0, len-1);
    }
    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start+ (end-start) / 2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}
