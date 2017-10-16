class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] stat = new int[26];
        int len1 = s1.length(), size = s2.length();
        if (size < len1) return false;
        for (int i = 0; i < len1; i++) {
            stat[s1.charAt(i)-'a']++;
        }
        int nc = 0;
        for (int i = 0; i < len1; i++) if (stat[s2.charAt(i)-'a']-- == 0) nc++;
        if (0 == nc) return true;
        for (int i = len1; i < size; i++) {
            if (stat[s2.charAt(i)-'a']-- == 0) nc++;
            if (++stat[s2.charAt(i-len1)-'a'] == 0) nc--;
            if (0 == nc) return true;
        }
        return false;
    }
}
