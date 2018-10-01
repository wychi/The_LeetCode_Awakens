
//Key:
    //1. Confirm is BST or not !!!
    //Time:O(N)
    //Space:O(N)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q
            || root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null != left && null != right) return root;
        return null != left ? left : right;
    }
    
