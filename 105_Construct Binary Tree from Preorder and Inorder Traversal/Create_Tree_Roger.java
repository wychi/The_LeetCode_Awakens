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
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return createTree(preorder, 0, inorder, 0, inorder.length - 1);
    }

    public TreeNode createTree(int[] preorder, int pStart, int[] inorder, int iStart, int iEnd) {
        if (pStart >= preorder.length || iStart > iEnd) {
            return null;
        }

        int root = preorder[pStart];
        int iRoot;
        for (iRoot = iStart; iRoot <= iEnd; ++iRoot) {
            if (inorder[iRoot] == root) {
                break;
            }
        }

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = createTree(preorder, pStart + 1, inorder, iStart, iRoot - 1);
        rootNode.right = createTree(preorder, pStart + iRoot - iStart + 1, inorder, iRoot + 1, iEnd);

        return rootNode;
    }
}
