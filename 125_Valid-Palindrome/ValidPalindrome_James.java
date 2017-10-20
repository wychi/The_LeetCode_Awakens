package com.myleetcode;

public class LeetCode125 {
    public static void main(String[] args) {
        // write your code here
        LeetCode125 obj = new LeetCode125();
        System.out.println("" + obj.isPalindrome("..5.."));
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int a = s.codePointAt(i);
            int b = s.codePointAt(j);
            if (!Character.isAlphabetic(a) && !Character.isDigit(a)) {
                i++;
                continue;
            } else if (!Character.isAlphabetic(b) && !Character.isDigit(b)) {
                j--;
                continue;
            } else if (i == j) {
                return true;
            }
            if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}
