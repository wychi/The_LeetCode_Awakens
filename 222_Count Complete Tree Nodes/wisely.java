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
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        int r = 0;
        TreeNode left = root, right = root;
        while (right!=null) {
            r++;
            left=left.left;
            right=right.right;
        }
        return left==null ? (1<<r)-1 : 1+countNodes(root.left)+countNodes(root.right);
    }
}