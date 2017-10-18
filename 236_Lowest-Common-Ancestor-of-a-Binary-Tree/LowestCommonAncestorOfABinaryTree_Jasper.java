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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> pParents = new ArrayList<>();
        List<TreeNode> qParents = new ArrayList<>();

        findParents(root, p, pParents);
        findParents(root, q, qParents);
                
        for(int i=0;i<pParents.size() && i<qParents.size();i++) {            
            if(i == (pParents.size() - 1) || i == (qParents.size() -1)) {
                return pParents.get(i);
            } else if(pParents.get(i+1) != qParents.get(i+1)) {
                return pParents.get(i);
            }            
        }   
        
        return root;
    }
    
    private boolean findParents(TreeNode root, TreeNode target, List<TreeNode> parents) {
        parents.add(root);
        
        if(root == target) 
            return true;
        
        boolean found = false;
        
        if(!found && root.left!=null) {
            found = findParents(root.left, target, parents);  
        }             
       
        if(!found && root.right!=null) {
            found = findParents(root.right, target, parents);
        } 
            
        if(!found) {            
            parents.remove(parents.size()-1);
        }    
        
        return found;
    }
    
    
}