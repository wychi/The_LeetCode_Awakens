package com.myleetcode;

import com.myleetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        root.left = n5;
        TreeNode n1 = new TreeNode(1);
        root.right = n1;
        TreeNode n6 = new TreeNode(6);
        n5.left = n6;
        TreeNode n2 = new TreeNode(2);
        n5.right = n2;
        TreeNode n0 = new TreeNode(0);
        n1.left = n0;
        TreeNode n8 = new TreeNode(8);
        n1.right = n8;
        TreeNode n7 = new TreeNode(7);
        n2.left = n7;
        TreeNode n4 = new TreeNode(4);
        n2.right = n4;
        LeetCode236 obj = new LeetCode236();
        TreeNode n = obj.lowestCommonAncestor2(root, n5, n1);
        System.out.println("n = " + (n == null ? "null" : n.val));
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = findPath(root, p);
        List<TreeNode> listQ = findPath(root, q);
//        System.out.println("listP = " + (listP == null ? 0 : listP.size()));
//        System.out.println("listQ = " + (listQ == null ? 0 : listQ.size()));
//        print(listP);
//        print(listQ);
        if (listP == null || listQ == null) {
            return null;
        }
        while (!listP.isEmpty() && !listQ.isEmpty()) {
            int sizeP = listP.size();
            int sizeQ = listQ.size();
            TreeNode nodeP = listP.get(0);
            TreeNode nodeQ = listQ.get(0);
            if (nodeP.val == nodeQ.val) {
                return nodeP;
            } else if (sizeP > sizeQ) {
                listP.remove(0);
            } else if (sizeP == sizeQ) {
                listP.remove(0);
                listQ.remove(0);
            } else if (sizeP < sizeQ) {
                listQ.remove(0);
            }
        }

        return null;
    }

    private List<TreeNode> findPath(TreeNode start, TreeNode target) {
        if (start.left == null
                && start.right == null
                && start != target) {
            return null;
        }
        if (start.left != null) {
            List list = findPath(start.left, target);
            if (list != null) {
                list.add(start);
                return list;
            }
        }
        if (start.right != null) {
            List list = findPath(start.right, target);
            if (list != null) {
                list.add(start);
                return list;
            }
        }
        if (start == target) {
            List list = new ArrayList();
            list.add(target);
            return list;
        }
        return null;
    }

    private void print(List<TreeNode> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); ++i) {
                TreeNode n = list.get(i);
                sb.append(n.val);
                if (i != list.size() - 1) {
                    sb.append(" -> ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
