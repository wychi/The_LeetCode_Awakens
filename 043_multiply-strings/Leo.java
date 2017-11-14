class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length(), len = len1+len2;
        if (("0".equals(num1)) || "0".equals(num2)) return "0";
        int [] ret = new int[len];
        for (int i = len1-1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                ret [i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = len-1; i>=1; i--) {
            ret[i-1] += ret[i]/10;
            ret[i] %= 10;
        }
        int idx = 0;
        while (ret[idx] == 0) idx++;
        StringBuilder sb = new StringBuilder();
        while (idx < len) sb.append(ret[idx++]);
        return sb.toString();
    }
}
