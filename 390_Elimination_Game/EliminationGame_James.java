package com.myleetcode;

public class LeetCode390 {
    public static void main(String[] args) {
        LeetCode390 obj = new LeetCode390();
        System.out.println("result = " + obj.lastRemaining(100));
    }

    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * (n / 2 + 1 - lastRemaining(n / 2));
        }
    }
}
