package com.myleetcode;

import java.util.Stack;

public class LeetCode402 {
    public static void main(String[] args) {
        // write your code here
        LeetCode402 obj = new LeetCode402();
        System.out.println(obj.removeKdigits("1432219", 3));

    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if (k == len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                Character c = stack.pop();
                System.out.println("pop, " + c);
                k--;
            }
            System.out.println("push, " + num.charAt(i));
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while (k > 0) {
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
