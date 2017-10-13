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
    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Integer> starts = new ArrayList<>();
        ArrayList<Integer> ends = new ArrayList<>();
        
        dfs(root, 1, 1, starts, ends);
        
        int max = 0;
        for(int i=0;i<starts.size(); i++) {
            int distance = ends.get(i) - starts.get(i) + 1;
            max = Math.max(max, distance);
        }
        return max;
    }
    
    private void dfs(TreeNode node, int level, int id, List<Integer> starts, List<Integer> ends) {
        if(node == null)
            return;
        
        if(starts.size() < level) {
            starts.add(id);
            ends.add(id);
        }
        if(ends.size() >= level) {
            ends.set(level-1, id);
        }
        
        if(node.left != null) {
            dfs(node.left, level+1, id*2, starts, ends);
        }
        if(node.right != null) {
            dfs(node.right, level+1, id*2 + 1, starts, ends);
        }
    }
}
