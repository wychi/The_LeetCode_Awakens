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
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
               height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                                         : (1 << h-1) + countNodes(root.left);
    }
    
    public int countNodes1(TreeNode root) {
        if(root == null)
            return 0;

        int level = 0;
        TreeNode left = root;
        TreeNode right = root;
        while(right != null) {
            left = left.left;
            right = right.right;
            level++;
        }
        
        if(left == null)
            return (int)Math.pow(2, level)-1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
