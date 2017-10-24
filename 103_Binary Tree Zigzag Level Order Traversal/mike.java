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
        List<List<Integer>> rList = new ArrayList();
        int level = 0;
        zigZagTrav(root, level, rList);
        return rList;
    }

    private void zigZagTrav(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        if (list.size() < level + 1 || list.get(level) == null) {
            List<Integer> l = new ArrayList();
            list.add(l);
        }

        if (level%2==0) {
            list.get(level).add(root.val);
        } else {
            list.get(level).add(0,root.val);
        }
        zigZagTrav(root.left, level+1, list);
        zigZagTrav(root.right, level+1, list);
    }
}
