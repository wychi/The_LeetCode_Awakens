class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = 0; 
        TreeNode left = root.left, right = root.right;
        while (null != right) {
            left = left.left;
            right = right.left;
            h++;
        }
        return (1<<h) + ((left == null) ? countNodes(root.right) : 
            ( countNodes(root.left)));
    }
}
