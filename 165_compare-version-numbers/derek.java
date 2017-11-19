class Solution {
    //.1 => true
    
    //Time: O(N), N is length of string
    //Space:O(1)
    public boolean isNumber(String s) {
        s = s.trim(); //"1 "
        boolean numSeen = false;
        boolean eSeen = false;
        boolean pointSeen = false;
        boolean numAfterE = false;
        
        char c;
        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if ('e' == c) {
                if (eSeen) return false;
                if (!numSeen) return false;
                eSeen = true;
                numAfterE = false;
            } else if ('.' == c) {
                if (pointSeen || eSeen) return false;
                pointSeen = true;
            } else if (c >= '0' && c <= '9') {
                numSeen = true;
                numAfterE = true;
            } else if ('-' == c || '+' == c) {
                if (i != 0 && 'e' != s.charAt(i-1)) {
                    return false;
                }
            } else {
                //" "
                return false;
            }
        }
        return numSeen && numAfterE;
    }
}
