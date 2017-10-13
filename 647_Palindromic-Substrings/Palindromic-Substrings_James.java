package com.myleetcode;

public class LeetCode647 {
    public static void main(String[] args) {
        // write your code here
        LeetCode647 obj = new LeetCode647();
        System.out.println("" + obj.countSubstrings("adadddddadadad"));
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += getPalindromicStringCount(s, i, i);
            count += getPalindromicStringCount(s, i, i + 1);
        }
        return count;
    }

    private int getPalindromicStringCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
