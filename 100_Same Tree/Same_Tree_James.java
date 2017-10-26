package com.myleetcode;

import com.myleetcode.data.TreeNode;

public class LeetCode100 {
    public static void main(String[] args) {
        // write your code here
        LeetCode100 obj = new LeetCode100();
        boolean b = obj.isSameTree(new TreeNode(0), new TreeNode(0));
        System.out.println(b);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}
