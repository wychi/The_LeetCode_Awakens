class Solution {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> list = new LinkedList<>();//1432219, 3
        for (int i = 0, size = num.length(); i < size; i++) {
            char c = num.charAt(i);
            while (k > 0 && !list.isEmpty() && list.getLast() > c) {
                list.removeLast();
                k--;
            }
            list.add(c);
        }
        while (!list.isEmpty() && k-- > 0) list.removeLast();
        boolean leadingZero = true;
        StringBuilder sb = new StringBuilder();
        for (Character c:list) {
            if (c == '0' && leadingZero) continue;
            leadingZero = false;
            sb.append(c);
        }
        return sb.length() > 0 ? sb.toString(): "0";
    }
}
