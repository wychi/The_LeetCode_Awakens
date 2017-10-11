package com.myleetcode;

public class LeetCode467 {
    public static void main(String[] args) {
        LeetCode467 obj = new LeetCode467();
        System.out.println(obj.findSubstringInWraproundString("cbc"));
    }

    public int findSubstringInWraproundString(String p) {
        int sum = 0;
        int count[] = new int[26];
        int maxLen = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLen++;
            } else {
                maxLen = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLen);
        }
        for (int c : count) {
            sum += c;
        }
        return sum;
    }
}
