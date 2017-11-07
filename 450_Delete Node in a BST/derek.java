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
    //Key:
    //Dummy node
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) return root;
        
        TreeNode curr = root, prev = new TreeNode(key+1);
        prev.left = root;
        root = prev; //change new root to dummy node
        
        boolean isLeft = true;
        //Find node in BST
        while (null != curr) {
            if (curr.val == key) {
                break;
            } else if (curr.val > key) {
                isLeft = true;
                prev = curr;
                curr = curr.left;
            } else {
                isLeft = false;
                prev = curr;
                curr = curr.right;
            }
        }
        if (null == curr) return root.left;
        
        TreeNode nh, nl;
        if (null != curr.right) {
            nh = curr.right;
            nl = curr.left;
        } else {
            nh = curr.left;
            nl = null;
        }
        if (isLeft) {
            prev.left = nh;
        } else {
            prev.right = nh;
        }
        if (null == nl) return root.left;
        while (null != nh.left) nh = nh.left;
        nh.left = nl;
        return root.left;
    }
}
