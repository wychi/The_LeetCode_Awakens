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
    //Time:O(N) each node
    //iterative 2 stack
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if (null == p || null == q) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        if (null != p) stackP.push(p);
        if (null != q) stackQ.push(q);
        TreeNode currP, currQ;
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            currP = stackP.pop();
            currQ = stackQ.pop();
            if (currP.val != currQ.val) return false;
            if (null != currP.left) stackP.push(currP.left);
            if (null != currQ.left) stackQ.push(currQ.left); 
            if (stackP.size() != stackQ.size()) return false;
            if (null != currP.right) stackP.push(currP.right);
            if (null != currQ.right) stackQ.push(currQ.right); 
            if (stackP.size() != stackQ.size()) return false;
        }
        return stackP.size() == stackQ.size();
    }
    
    //recursive
    // public boolean isSameTree(TreeNode p, TreeNode q) {
        // if (null == p && null == q) return true;
        // if (null == p || null == q) return false;
    //     if (p.val == q.val) {
    //         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    //     } else {
    //         return false;
    //     }
    // }
}
