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
        return constructTree(  0, preorder
                             , 0, inorder.length-1, inorder);
    }
    
    private TreeNode constructTree(int pStart, int[] preorder, int iStart, int iEnd, int[] inorder) {
        if (pStart > inorder.length - 1 || iStart > iEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pStart]);
        int currIdx = 0;
        for (int i = iStart; i<=iEnd; i++) {
            if (inorder[i] == root.val) {
                currIdx = i;
                break;
            }
        }
        
        root.left = constructTree(pStart+1, preorder, iStart, currIdx-1, inorder);
        root.right = constructTree(pStart + (currIdx-iStart+1), preorder, currIdx+1, iEnd, inorder);
        return root;
    }
}
