class Solution {
    public void doAddOneRow(TreeNode root, int v, int d) {
        if (null == root) return;
        if (--d > 0) {
            doAddOneRow(root.left, v, d);
            doAddOneRow(root.right, v, d);
            return;
        }
        TreeNode n = new TreeNode(v);
        n.left = root.left;
        root.left = n;
        n = new TreeNode(v);
        n.right = root.right;
        root.right = n;
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        doAddOneRow(dummy, v, d);
        return dummy.left;
    }
}
