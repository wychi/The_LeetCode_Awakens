package com.myleetcode;

import com.myleetcode.data.TreeNode;

import java.util.*;

public class LeetCode662 {
    public static void main(String[] args) {
        // write your code here
    }

    public static class Entry<T> {
        public T key;
        public int value;

        public Entry(T t, int v) {
            key = t;
            value = v;
        }
    }

    //BFS
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<Entry> q = new LinkedList<>();
        q.offer(new Entry<>(root, 1));

        while (!q.isEmpty()) {
            int l = q.peek().value, r = l;
            for (int i = 0, n = q.size(); i < n; i++) {
                TreeNode node = (TreeNode) q.peek().key;
                r = q.poll().value;
                if (node.left != null) q.offer(new Entry<>(node.left, r * 2));
                if (node.right != null) q.offer(new Entry<>(node.right, r * 2 + 1));
            }
            max = Math.max(max, r + 1 - l);
        }
        return max;
    }
}
