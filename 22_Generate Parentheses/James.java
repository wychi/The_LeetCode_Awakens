package com.myleetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode022 {
    public static void main(String[] args) {
        // write your code here
        LeetCode022 obj = new LeetCode022();
        obj.generateParenthesis(3);
        System.out.println();
        obj.generateParenthesis2(3);

    }


    public List<String> generateParenthesis(final int n) {

        List<String> result = new ArrayList<>();
        String str = "";
        if (n > 0) {
            backtrace(result, str, 0, 0, n);
        } else if (n == 0) {
            result.add(str);
        } else {
            return result;
        }
        return result;
    }

    private void backtrace(List<String> list, String s, int a, int b, final int n) {
        if (s.length() == (2 * n)) {
            System.out.println(s);
            list.add(s);
            return;
        }

        if (a < n) {
            backtrace(list, s + "(", a + 1, b, n);
        }
        if (a > b) {
            backtrace(list, s + ")", a, b + 1, n);
        }
    }

    public List<String> generateParenthesis2(final int n) {

        List<String> result = new ArrayList<>();
        String str = "";
        if (n > 0) {
            backtrace2(result, str, n, n);
        } else if (n == 0) {
            result.add(str);
        } else {
            return result;
        }
        return result;
    }

    private void backtrace2(List<String> list, String s, int a, int b) {
        if (a > b) {
            return;
        }

        if (a > 0) {
            backtrace2(list, s + "(", a - 1, b);
        }
        if (b > 0) {
            backtrace2(list, s + ")", a, b - 1);
        }

        if (a == 0 && b == 0) {
            list.add(s);
            System.out.println(s);
            return;
        }
    }
}
