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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<TreeNode> level = new ArrayList<>();
        
        if(root!=null) {
            level.add(root);
        }        
        
        boolean zig = true;
        
        while(!level.isEmpty()) {
            Integer[] levelVal = new Integer[level.size()];
            List<TreeNode> nextLevel = new ArrayList<>();
            for(int i=0;i<level.size();i++) {
                    TreeNode node = level.get(i);
                    if(zig) {
                        levelVal[i] = node.val;
                    } else {
                        levelVal[level.size() - i -1] = node.val;
                    }
                    if(node.left!=null) {                     
                        nextLevel.add(node.left);   
                    }
                    if(node.right!=null) {                     
                        nextLevel.add(node.right);   
                    }
                }
            result.add(Arrays.asList(levelVal));
            level = nextLevel;
            zig = !zig;
        }
        return result;
    }
}
