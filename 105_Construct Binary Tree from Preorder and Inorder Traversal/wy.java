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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length);
    }
    
    TreeNode buildTree(int[] preorder, int s1, int[] inorder, int s2, int count) {
        if(count == 0)
            return null;
        
        TreeNode node = new TreeNode(preorder[s1]);
        if(count == 1)
            return node;
        
        int target = -1;
        for(int i=0; i<count; i++) {
            if(preorder[s1] == inorder[s2+i]) {
                target = s2+i;
                break;
            }
        }

        if(target != -1) {
            int leftCount = target - s2;
            int rightCount = count - leftCount - 1;

            if(leftCount > 0)
                node.left = buildTree(preorder, s1+1, inorder, s2, leftCount);

            if(rightCount > 0)
                node.right = buildTree(preorder, s1+leftCount+1, inorder, target+1, rightCount);

        }

        return node;
    } 
    
}
