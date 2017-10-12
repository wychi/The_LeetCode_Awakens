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
    //Method 1: in order (recursive)
    TreeNode firstNode = null, secondNode = null;
    TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);
//     public void recoverTree(TreeNode root) {
//         traverse(root);
        
//         int temp = firstNode.val;
//         firstNode.val = secondNode.val;
//         secondNode.val = temp;
//     }
//     private void traverse(TreeNode root) {
//         if (null == root) {
//             return;
//         }
        
//         traverse(root.left);
        
//         if (null == firstNode && prevNode.val >= root.val) {
//             firstNode = prevNode;
//         }
        
//         if (null != firstNode && prevNode.val >= root.val) {
//             secondNode = root;
//         }
//         prevNode = root;
        
//         traverse(root.right);
//     }
    //Method 1: END
    
    //Method 2: in order (iterative)
    //Time:  O(N)
    //Space: O(N)
    // public void recoverTree(TreeNode root) {
    //     if (null == root) {
    //         return;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode currNode = root;
    //     while (!stack.isEmpty() || null != currNode) {
    //         if (null != currNode) {
    //             stack.push(currNode);
    //             currNode = currNode.left;
    //         } else {
    //             currNode = stack.pop();
    //             if (null != prevNode && prevNode.val >= currNode.val) {
    //                 if (null == firstNode) {
    //                     firstNode = prevNode;
    //                 }
    //                 secondNode = currNode;
    //             }
    //             prevNode = currNode;
    //             currNode = currNode.right;
    //         }
    //     }
    //     int temp = firstNode.val;
    //     firstNode.val = secondNode.val;
    //     secondNode.val = temp;
    // }
    
    //Method 3: Morris Threaded tree
    //Time:  O(N)
    //Space: O(1)
    public void recoverTree(TreeNode root) {
        TreeNode prev = null, last = null;
        TreeNode curr = root;
        while (null != curr) {
            if (null == curr.left) {
                // print(cur);
                if (null != last && last.val >= curr.val) {
                    if (null == firstNode) {
                        firstNode = last;
                    }
                    secondNode = curr;
                }
                last = curr;
                
                curr = curr.right;
            } else {
                prev = curr.left;
                while (null != prev.right
                       && curr != prev.right) {
                    prev = prev.right;
                }
                if (null == prev.right) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    // print(cur);
                    if (null != last && last.val >= curr.val) {
                        if (null == firstNode) {
                            firstNode = last;
                        }
                        secondNode = curr;
                    }
                    last = curr;
                    
                    curr = curr.right;
                }
            }
        }
        if (null != firstNode && null != secondNode) {
            int temp = firstNode.val;
            firstNode.val = secondNode.val;
            secondNode.val = temp;
        }
    }
}
