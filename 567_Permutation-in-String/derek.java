class Solution {
    //Method 1:
    public boolean checkInclusion(String s1, String s2) {
        if (null == s1 || s1.length() <= 0) return false;
        if (null == s2 || s2.length() <= 0) return false;

        int[] chs = new int[26];
        for (char c: s1.toCharArray()) {
            chs[c-'a']++;
        }
        
        int[] chs2 = new int[26];
        for (int i = 0 ; i<= s2.length()-s1.length(); i++) {
            Arrays.fill(chs2, 0); //restore value
            for (int j = i; j<i+s1.length(); j++) {
                chs2[s2.charAt(j)-'a']++;
                if (equalsArray(chs, chs2)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean equalsArray(int[] chs, int[] chs2) {
        if (null == chs || null == chs2) return false;
        if (chs.length != chs.length) return false;
        for (int i = 0 ; i<chs.length; i++) {
            if (chs[i] != chs2[i]) {
                return false;
            }
        }
        return true;
    }
}
