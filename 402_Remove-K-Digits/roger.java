class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> substring = new LinkedList<>();

        for (int i = 0; i < num.length(); ++i) {
            char ch = num.charAt(i);
            while (k > 0 && !substring.isEmpty() && substring.getLast() > ch) {
                substring.removeLast();
                k--;
            }
            substring.add(ch);
        }

        while (k-- > 0) {
            substring.removeLast();
        }

        boolean zeroStart = true;
        StringBuilder sb = new StringBuilder();

        for (Character ch: substring) {
            if (ch == '0' && zeroStart) {
                continue;
            }
            zeroStart = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
