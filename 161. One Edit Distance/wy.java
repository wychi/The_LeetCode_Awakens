public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        
        int count = s.length() - t.length();
        if(count < 0)
            return isOneEditDistance(t, s);
        if(count > 1)
            return false;
        
        
        return isOneEditDistance(s, t, 1);
        
    }
    
    boolean isOneEditDistance(String s, String t, int count) {
        
        boolean isSame = true;
        int idx = 0;
        while(idx < t.length()) {
            if(s.charAt(idx) != t.charAt(idx)) {
                isSame = false;
                break;
            }
            idx++;
        }
        
        if(isSame) {
            return s.length() > t.length() ? count == 1 : count == 0;
        }
        
        if(count == 0)
            return false;
        
        if(s.length() > t.length())
            return isOneEditDistance(s.substring(idx+1), t.substring(idx), 0);
        
        return isOneEditDistance(s.substring(idx+1), t.substring(idx+1), 0);

    }
}
