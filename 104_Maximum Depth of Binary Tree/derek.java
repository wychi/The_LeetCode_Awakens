/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//BFS
//
public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        int currDepth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode currNode = null;
        int childNum = 0;
        int depth = 0;
        while (!queue.isEmpty()) {
            childNum = queue.size();
            while (childNum-- > 0) {
                currNode = queue.remove();
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            
            depth++;
        }
        return depth;
    }

//DFS
class Solution {
    //DFS stack
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        int currDepth = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> depth = new Stack<Integer>();
        stack.push(root);
        depth.push(1);
        TreeNode curr = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            currDepth = depth.pop();
            max = Math.max(currDepth, max);
            
            if (curr.left != null) {
                stack.push(curr.left);
                depth.push(currDepth+1);
            }
            if (curr.right != null) {
                stack.push(curr.right);
                depth.push(currDepth+1);
            }
        }
        return max;
    }
}

//Recursive
class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
