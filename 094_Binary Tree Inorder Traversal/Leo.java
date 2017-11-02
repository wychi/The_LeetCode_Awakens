class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (null != root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            while (root == null && !stack.isEmpty()) {
                root = stack.pop();
                ret.add(root.val);
                root = root.right;
            }
        }
        return ret;
    }
}
