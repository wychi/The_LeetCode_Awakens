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
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        
        while(!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> list = new ArrayList<>(n);
            
            for(int i=0; i<n; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                if(level % 2 == 1)
                    list.add(node.val);
                else
                    list.add(0, node.val);
            }
            result.add(list);
            level++;
        }
        
        return result;
    }
}
