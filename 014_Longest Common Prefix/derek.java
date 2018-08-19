

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length <= 0) return "";
        if (strs.length == 1) return strs[0];
        int shortestIdx = Integer.MAX_VALUE;
        int shortestLen = Integer.MAX_VALUE;
        for (int i = 0 ; i<strs.length; i++) {
            String str = strs[i];
            if (str.length() < shortestLen) {
                shortestIdx = i;
                shortestLen = str.length();
            }
        }
        String shortestString = strs[shortestIdx];
        int i = 0;
        for (i = 0 ; i<shortestString.length() ;i++) {
            for (int idx = 0 ; idx<strs.length; idx++) {
                if (shortestString.charAt(i) != strs[idx].charAt(i)) {
                    return shortestString.substring(0, i);
                }
            }
        }
        return i == shortestString.length() ? shortestString: "";
    }
}
