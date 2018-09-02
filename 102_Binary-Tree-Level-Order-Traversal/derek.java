/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Time:O(N)
//Space:O(N)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) return result;
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            level = new ArrayList<>();
            for (int i = 0 ; i<levelNodeNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                level.add(queue.poll().val);
            }
            result.add(level);
        }
        return result;
    }
}
