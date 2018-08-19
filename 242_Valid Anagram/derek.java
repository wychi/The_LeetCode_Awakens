class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charArray = new char[26];
        for (char c: s.toCharArray()) {
            charArray[c-'a']++;
        }
        for (char c: t.toCharArray()) {
            charArray[c-'a']--;
        }
        for (int i = 0 ; i<26; i++) {
            if (charArray[i] != 0) return false;
        }
        return true;
    }
}
