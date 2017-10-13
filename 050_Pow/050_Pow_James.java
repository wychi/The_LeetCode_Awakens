package com.myleetcode;

public class LeetCode050 {
    public static void main(String[] args) {
        // write your code here
        LeetCode050 obj = new LeetCode050();
        System.out.println("" + obj.myPow(2, -2));
    }

    public double myPow(double x, int n) {
        double tmp;
        if (n == 0) {
            return 1;
        }
        tmp = myPow(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            if (n > 0) {
                return x * tmp * tmp;
            } else {
                return tmp * tmp / x;
            }
        }
    }
}
