class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        int head = 0, tail = 0;
        for (int i = 0 ; i<=haystack.length()-needle.length() ; i++) {
            boolean found = true;
            for (int j = 0 ; j<needle.length() ; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;
        int head = 0, tail = 0;
        for (int i = 0 ; i<=haystack.length()-needle.length() ; i++) {
            for (int j = 0 ; j<needle.length() ; j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                } else {
                    if (isSubString(i, haystack, needle)) {
                        return i;
                    } else break;
                }
                
            }
        }
        return -1;
    }
    private boolean isSubString(int index, String a, String sub) {
        for (int i=0; i<sub.length(); i++) {
            if (a.charAt(index++) != sub.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
