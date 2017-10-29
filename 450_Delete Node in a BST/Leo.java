class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root, prev = new TreeNode(key+1);
        prev.left = root; root = prev;
        boolean isLeft = true;
        while (node != null) {
            if (node.val == key) break;
            prev = node;
            if (node.val < key) {
                node = node.right;
                isLeft = false;
            } else if (node.val > key){
                isLeft = true;
                node = node.left;
            }
        }
        if (node == null) return root.left;
        TreeNode nh = (node.right != null) ? nh = node.right : node.left;
        TreeNode nl = (node.right != null) ? nl = node.left : null;
        if (isLeft) {
            prev.left = nh;
        } else {
            prev.right = nh;
        }
        if (null == nh) return root.left;
        while (nh.left != null) nh = nh.left;
        nh.left = nl;
        return root.left;
    }
}
