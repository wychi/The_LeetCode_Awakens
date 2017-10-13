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
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i< inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return getTreeNode(0, preorder.length, 0, inorder.length, preorder, inorder, inMap);
    }
    
    private TreeNode getTreeNode(int preStart, int preEnd, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap) {
        TreeNode node = new TreeNode(preorder[preStart]);
        int leftSize = inMap.get(preorder[preStart]) - inStart;
        int rightSize = preEnd - preStart - 1 - leftSize;
        if (leftSize > 0) {
            node.left = getTreeNode(preStart + 1, preStart + 1 + leftSize, inStart, inStart + leftSize, preorder, inorder, inMap);
        }
        if (rightSize > 0) {
            node.right = getTreeNode(preStart + 1 + leftSize, preEnd, inStart + leftSize + 1, inEnd, preorder, inorder, inMap);
        }
        return node;
    }
}