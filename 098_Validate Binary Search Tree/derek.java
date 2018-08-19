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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode = null;
        while (root != null || !stack.isEmpty()) {
            //Put left child node first
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prevNode != null && prevNode.val >= root.val) {
                return false;
            }
            prevNode = root;
            root = root.right;
        }
        return true;
    }
}
