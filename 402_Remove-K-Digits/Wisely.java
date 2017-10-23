O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length() || num.length() == 0) return "0";
        int pick = num.length() - k;
        char[] cs = new char[pick]; cs[0] = num.charAt(0);
        int charStart = 1;
        for (int i = 1; i < num.length(); i++) {
            char next = num.charAt(i);
            while (charStart > 0 && next < cs[charStart-1] && (num.length() - i - 1) >= (pick - charStart)) {
                charStart--;
            }
            if (charStart >= pick) continue;
            cs[charStart++] = next;
        }
        int start = 0;
        for (start = 0; start < pick; start++) {
            if (cs[start] != '0') break;
        }
        return start == pick ? "0" : new String(cs, start, pick - start);
    }
}

O(n*k)
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        int pick = num.length() - k;
        String result = dp(num, pick);
        int start = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                start++;
            } else {
                break;
            }
        }
        return start == result.length() ? "0" : result.substring(start);
    }
    
    private String dp(String num, int pick) {
        if (pick == num.length()) {
            return num;
        }
        int min = 0;
        for (int i = 1; i < num.length() - pick + 1; i++) {
            if (num.charAt(i) < num.charAt(min)) {
                min = i;
            }
        }
        pick--;
        if (pick == 0)
            return "" + num.charAt(min);
        else
            return "" + num.charAt(min) + dp(num.substring(min + 1), pick);
    }
}