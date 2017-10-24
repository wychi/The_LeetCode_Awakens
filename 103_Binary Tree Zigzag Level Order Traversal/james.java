package com.myleetcode;

import com.myleetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode103 {
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        n0.left = n1;
        TreeNode n2 = new TreeNode(20);
        n0.right = n2;
        TreeNode n3 = new TreeNode(15);
        n2.left = n3;
        TreeNode n4 = new TreeNode(7);
        n2.right = n4;


        LeetCode103 obj = new LeetCode103();
        List<List<Integer>> group = obj.zigzagLevelOrder(n0);
        for (List<Integer> l : group) {
            StringBuilder sb = new StringBuilder();
            for (int i : l) {
                sb.append("" + i + ", ");
            }
            sb.append("\n");
            System.out.println(sb.toString());
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        long start = System.currentTimeMillis();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        boolean reverse = true;
        boolean isFirst = true;
        List<TreeNode> ns = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        ns.add(root);
        List<Integer> levelNodesValList = null;
        while (!ns.isEmpty()) {
            if (isFirst) {
                levelNodesValList = new ArrayList<>();
                lists.add(levelNodesValList);
                isFirst = false;
            }
            TreeNode t = ns.get(ns.size() - 1);
            ns.remove(ns.size() - 1);
            levelNodesValList.add(t.val);
            if (reverse) {
                if (t.left != null) {
                    temp.add(t.left);
                }
                if (t.right != null) {
                    temp.add(t.right);
                }
            } else {
                if (t.right != null) {
                    temp.add(t.right);
                }
                if (t.left != null) {
                    temp.add(t.left);
                }
            }

            if (ns.isEmpty() && !temp.isEmpty()) {
                reverse = !reverse;
                ns = temp;
                temp = new ArrayList<>();
                isFirst = true;
            }
        }

        System.out.println("spend = " + (System.currentTimeMillis() - start));
        return lists;
    }
}
