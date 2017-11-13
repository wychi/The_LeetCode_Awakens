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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode tmp = new TreeNode(v);
            tmp.left = root;
            return tmp;
        }
            
        dfs(root, v, d, 1);
        return root;
    }
    
    void dfs(TreeNode node, int v, int d, int level) {
        if(node == null)
            return;
        
        if(level == d-1) {
            TreeNode tmp = new TreeNode(v);
            tmp.left = node.left;
            node.left = tmp;
            
            tmp = new TreeNode(v);
            tmp.right = node.right;
            node.right = tmp;
            
            return;
        }
        
        dfs(node.left, v, d, level+1);
        dfs(node.right, v, d, level+1);
    }
}
