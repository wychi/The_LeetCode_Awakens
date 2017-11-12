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
    
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(dummy); 
        while (d-- > 1) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode n = queue.pop();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            TreeNode n = new TreeNode(v);
            n.left = node.left;
            node.left = n;
            n = new TreeNode(v);
            n.right = node.right;
            node.right = n;
        }
        return dummy.left;
    }
}
