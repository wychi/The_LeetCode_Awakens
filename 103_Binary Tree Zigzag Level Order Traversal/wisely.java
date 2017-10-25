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
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        int start = 1;
        Queue<TreeNode> tnQ = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        tnQ.add(root); indexQ.add(1);
        List<Integer> dataList = new ArrayList<>();
        while (!tnQ.isEmpty()) {
            TreeNode tn = tnQ.poll();
            int index = indexQ.poll();
            if (index != start) {
                resultList.add(dataList);
                dataList = new ArrayList<>();
                start = index;
            }
            if (start % 2 == 0) {
                dataList.add(0, tn.val);
            } else {
                dataList.add(tn.val);
            }
            if (tn.left != null) {
                tnQ.add(tn.left);
                indexQ.add(start + 1);
            }
            if (tn.right != null) {
                tnQ.add(tn.right);
                indexQ.add(start + 1);
            }
        }
        resultList.add(dataList);
        return resultList;
    }
}