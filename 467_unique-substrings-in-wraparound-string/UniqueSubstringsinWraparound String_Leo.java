class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] charInfo = new int[26];
        int size = p.length();
        if (size <= 1) return size;
        char prev = p.charAt(0);
        int length = 0;
        for (int i = 0; i < size; i++) {
            char current = p.charAt(i);
            int diff = current - prev;
            if (1 == diff || -25 == diff)) {
                length++;
            } else {
                length = 1;
            }
            prev = current;
            int index = prev - 'a';
            if (charInfo[index] < length) charInfo[index] = length;
        }
        
        int ret = 0;
        for (int i = 0, len = charInfo.length; i < len; i++) {
            ret += charInfo[i];
        }
        return ret;
    }
}
