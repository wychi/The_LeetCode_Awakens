class Solution {
    public int firstUniqChar(String s) {
        char[] charArray = new char[26];
        for (char c: s.toCharArray()) {
            charArray[c-'a']++;
        }
        for (int i = 0; i<s.length(); i++) {
            if (charArray[s.charAt(i)-'a'] < 2) return i;
        }
        return -1;
    }
}
