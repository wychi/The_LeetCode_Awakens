class Solution {
    public String addBinary(String a, String b) {
        int aPos = a.length() -1;
        int bPos = b.length() -1;
        int inc = 0;
        String result = "";
        while (aPos > -1 || bPos > -1) {
            char av = aPos > -1 ? a.charAt(aPos) : '0';
            char bv = bPos > -1 ? b.charAt(bPos) : '0';
            inc = inc + (av == '0' ? 0 : 1) + (bv == '0' ? 0 : 1);
            result = (inc & 1) + result;
            inc >>= 1;
            aPos--; bPos--;
        }
        if (inc == 1) result = "1" + result;
        return result.length() == 0 ? "0" : result;
    }
}