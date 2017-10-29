class Solution {
    public String addBinary(String a, String b) {
        int ia = a.length(), ib = b.length(), carry = 0, idx = Math.max(ia, ib);
        char[] ch = new char[idx];
        while (--idx >= 0) {
            int v = carry;
            if (--ia >= 0) v +=  a.charAt(ia) - '0';
            if (--ib >= 0) v +=  b.charAt(ib) - '0';
            carry = v >> 1;
            ch[idx] = (char) ((v & 1) + '0');
        }
        StringBuilder sb = new StringBuilder();
        if (carry > 0) sb.append(1);
        return sb.append(ch).toString();
    }
}
