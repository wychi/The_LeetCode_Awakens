class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop().charValue() != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop().charValue() != '[') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop().charValue() != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> data = new Stack<Character>();
        for (char c: s.toCharArray()) {
            if ('(' == c) {
                data.push(c);
            } else if (')' == c) {
                if (data.isEmpty()) return false;
                if ('(' != data.pop().charValue()) return false;
            } else if ('[' == c) {
                data.push(c);
            } else if (']' == c) {
                if (data.isEmpty()) return false;
                if ('[' != data.pop().charValue()) return false;
            } else if ('{' == c) {
                data.push(c);
            } else if ('}' == c) {
                if (data.isEmpty()) return false;
                if ('{' != data.pop().charValue()) return false;
            }
        }
        return data.isEmpty();
    }
}
