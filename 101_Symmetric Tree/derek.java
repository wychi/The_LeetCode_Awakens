/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return null == root || isSymmtricHelp(root.left, root.right);
    }
    
    private boolean isSymmtricHelp(TreeNode left, TreeNode right) {
        if (null == left || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmtricHelp(left.left, right.right)
            && isSymmtricHelp(left.right, right.left);
    }
}

//Iterative
public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
