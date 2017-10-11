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
    public void recoverTree(TreeNode root) {
        //TreeNode prev = null;
        TreeNode cur = root;
        TreeNode pre = null;
        
        TreeNode first = null;
        TreeNode second = null;
        
        while(cur != null) {
            
            
            if(cur.left != null) {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                
                if(prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println(cur.val + ", ");
                    
                    if(pre!=null && pre.val > cur.val){
                        if(first==null){first = pre;second = cur;}
				        else{second = cur;}
				    }
				    pre = cur;
                    
                    cur = cur.right;
                    prev.right = null;
                }
            } else {
                System.out.println(cur.val + ", ");
                if(pre!=null && pre.val > cur.val){
                        if(first==null){first = pre;second = cur;}
				        else{second = cur;}
                }
                pre = cur;
                
                cur = cur.right;
            }
        }
        
        swap(first, second);
    }
    
    public void recoverTree2(TreeNode root) {
        TreeNode dummy1 = new TreeNode(0);
        TreeNode dummy2 = new TreeNode(0);
        TreeNode dummy3 = new TreeNode(0);
        inorder(root, dummy1, dummy2, dummy3);
        
        TreeNode n1 = dummy1.left;
        TreeNode n2 = dummy2.left;
        swap(n1, n2);
    }
    
    void swap(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
    
    // [0, 1]
    // [2, null, 1]
    // [2,3,1]
    // []
    private void inorder(TreeNode root, TreeNode n1, TreeNode n2, TreeNode prev) {
        
        if(root == null)
            return;
        
        inorder(root.left, n1, n2, prev);
        
        // do stuff
        if(prev.left != null) {
            int prevVal = prev.left.val;
            if(prevVal >= root.val) {
                if(n1.left == null) n1.left = prev.left;
                if(n1.left != null) n2.left = root;
            }
        }
        prev.left = root;
        
        inorder(root.right, n1, n2, prev);
    }
}
