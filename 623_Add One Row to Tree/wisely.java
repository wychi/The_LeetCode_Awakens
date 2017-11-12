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
        if (d==1) {
            TreeNode node = new TreeNode(v);
            node.left=root;
            return node;
        }
        if (root==null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currentLevel=1;
        int size=1, tempSize=0;
        while (!q.isEmpty()) {
            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (currentLevel==d-1) {
                    TreeNode left=new TreeNode(v);
                    left.left=node.left;
                    TreeNode right=new TreeNode(v);
                    right.right=node.right;
                    node.left=left; node.right=right;
                } else {
                    if (node.left!=null) {
                        q.offer(node.left);
                        tempSize++;
                    }
                    if (node.right!=null) {
                        q.offer(node.right);
                        tempSize++;
                    }
                }
            }
            if (currentLevel==d-1)return root;;
            currentLevel++;
            size=tempSize;
            tempSize=0;
        }
        return root;
    }
}
