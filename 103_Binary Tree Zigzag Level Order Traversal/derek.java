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
    //1. level order, then odd: left -> right; even: right -> left
    //2. use bit manipulation to replace "%" operation
    //Method: iterative
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) return result;
        
        queue.offer(root);
        List<Integer> list;
        int size = 1, level = 0;
        TreeNode curr;
        while (!queue.isEmpty()) {
            list = new ArrayList<Integer>();
            
            for (int i = 0 ; i<size; i++) {
                curr = queue.poll();
                if ((level & 1) == 0) list.add(curr.val);
                else list.add(0, curr.val);
                if (null != curr.left) queue.offer(curr.left);
                if (null != curr.right) queue.offer(curr.right);
            }
            result.add(list);
            size = queue.size();
            level++;
        }
        return result;
    }
    
    //Method: recursive
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         levelOrder(root, result, 0);
//         return result;
//     }
    
//     private void levelOrder(TreeNode root, List<List<Integer>> levelList, int level) {
//         if (null == root) return;
        
//         List<Integer> list;
//         if (levelList.size() <= level) {
//             list = new ArrayList<>();
//             levelList.add(list);
//         }
        
//         list = levelList.get(level);
//         if ((level & 1) == 0) list.add(root.val);
//         else list.add(0, root.val);
        
//         levelOrder(root.left, levelList, level+1);
//         levelOrder(root.right, levelList, level+1);
//     }
}
