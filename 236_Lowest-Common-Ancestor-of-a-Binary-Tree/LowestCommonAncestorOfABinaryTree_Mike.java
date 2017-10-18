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
        List<TreeNode> l, listP, listQ;
        l = new ArrayList<TreeNode>();
        listP = new ArrayList(searchTree(root, p, l));
        l.clear();
        listQ = new ArrayList(searchTree(root, q, l));

        int lenP = listP.size();
        int lenQ = listQ.size();
        for(int i=0;i<lenP;i++) {
            System.out.print(""+listP.get(i).val+",");
        }
        System.out.println("");
        for(int i=0;i<lenQ;i++) {
            System.out.print(""+listQ.get(i).val+",");
        }
        if (lenP < lenQ) {
            return findFirstSameElement(listP, listQ);
        } else {
            return findFirstSameElement(listQ, listP);
        }
    }

    public List<TreeNode> searchTree(TreeNode node, TreeNode target, List<TreeNode> ancestors) {
        ancestors.add(node);
        // success case
        if (node == target) {
            return ancestors;
        }
        // terminal case
        if (node.left == null && node.right == null) {
            ancestors.remove(node);
            return null;
        }
        // general case
        List<TreeNode> list = null;
        if (node.left != null) {
            list = searchTree(node.left, target, ancestors);
        }

        if (list != null) {
            return list;
        }

        if (node.right != null) {
            list = searchTree(node.right, target, ancestors);
        }

        if (list != null) {
            return list;
        }

        ancestors.remove(node);
        return null;
    }

    public TreeNode findFirstSameElement(List<TreeNode> listP, List<TreeNode> listQ) {
        int index = 0;
        int len = listP.size();
        int i=0;
        for(i=0;i<len;i++) {
            if (listP.get(i) == listQ.get(index)) {
                index++;
                continue;
            } else {
                // terminal case
                if (listP.get(i-1) == listQ.get(index-1) || i > len) {
                    return listP.get(i-1);
                }
            }
        }
        return listP.get(i-1);
    }
}
