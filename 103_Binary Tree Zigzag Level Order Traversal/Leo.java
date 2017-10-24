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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        if (null != root) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.pop();
                if (reverse) {
                    list.addFirst(node.val);
                } else {
                    list.add(node.val);
                }
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
            ret.add(list);
            reverse = !reverse;
        }
        return ret;
    }
}
