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
    //Key:
    //1. Do not try to add lacked node as "null", that may comsume lots of memory if node is large enough
    //2. Add Number to every node
    //3. Relationship between Node i(root), 2i(left), 2i+1(right)
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    private int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (null == root) return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
             //Update rightmost
            end.set(level, order);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level+1, 2*order, start, end);
        int right = dfs(root.right, level+1, 2*order+1, start, end);
        return Math.max(cur, Math.max(left, right)/*If node is not balanced*/);
    }

}
