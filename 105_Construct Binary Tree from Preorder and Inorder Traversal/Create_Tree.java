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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (inorder.length != preorder.length) {
            return null;
        }
        return getTreeNode(0, preorder.length, 0, inorder.length, preorder, inorder);
    }
    
    private TreeNode getTreeNode(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(preorder[preStart]);
        int leftSize = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                leftSize = i - inStart;
                break;
            }
        }
        int rightSize = preEnd - preStart - 1 - leftSize;
        if (leftSize > 0) {
            node.left = getTreeNode(preStart + 1, preStart + 1 + leftSize, inStart, inStart + leftSize, preorder, inorder);
        }
        if (rightSize > 0) {
            node.right = getTreeNode(preStart + 1 + leftSize, preEnd, inStart + leftSize + 1, inEnd, preorder, inorder);
        }
        return node;
    }
}