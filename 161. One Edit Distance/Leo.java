    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 > len2) {
            String temp = s;s = t;t = temp;
            int tempL = len1; len1 = len2; len2 = tempL;
        }
        int i = 0, j = 0, diff = 0;
        while (i < len1) {
            if (s.charAt(i++) != t.charAt(j++)) {
                diff++;
                if (diff > 1) return false;
                if (len2 > len1) {
                    i--;
                }
            }
        }
        return diff == 1 || len2 - len1 == 1;
    }
