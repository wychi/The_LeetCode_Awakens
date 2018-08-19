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
