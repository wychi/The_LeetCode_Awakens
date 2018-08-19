public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode result = new TreeNode(t1.val+t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);
        return result;
    }



//TIme:O(N) the height is larger one
//Space:O(N)
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode result = new TreeNode(t1.val+t2.val);
        result.left = merge(t1.left, t2.left);
        result.right = merge(t1.right, t2.right);
        return result;
    }
    
    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        
        TreeNode node = null;
        if (t1 == null) {
            if (t2 != null) {
                node = new TreeNode(t2.val);
            }
        } else {
            if (t2 != null) {
                node = new TreeNode(t1.val + t2.val);
            }
        }
        if (node != null) {
            node.left = merge(t1.left, t2.left);
            node.right = merge(t1.right, t2.right);
        }
        return node;
    }
}
