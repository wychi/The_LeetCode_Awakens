class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            count++;
            int start = i - 1;
            int end = i + 1;
            while (start >= 0 && end < cs.length && cs[start] == cs[end]) {
                count++;
                start--; end++;
            }
            start = i; end = i + 1;
            while (start >= 0 && end < cs.length && cs[start] == cs[end]) {
                count++;
                start--; end++;
            }
        }
        return count;
    }
}