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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        search(root, key, dummy);
        return dummy.left;
    }
    
    void search(TreeNode node, int key, TreeNode pNode) {
        if(node == null)
            return;
        
        if(node.val > key) {
            search(node.left, key, node);
            return;
        } else if(node.val < key) {
            search(node.right, key, node);
            return;
        }
        
        TreeNode newRoot = null;
        if(node.left == null || node.right == null) {
            if(node.left != null) newRoot = node.left;
            else if(node.right != null) newRoot = node.right;
        } else {
            newRoot = node.right;
            TreeNode tmp = newRoot;
            while(tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = node.left;
        }
        
        if(pNode.left == node) pNode.left = newRoot;
        else if(pNode.right == node) pNode.right = newRoot;
    }
    
}
