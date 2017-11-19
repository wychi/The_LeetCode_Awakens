public class Solution {
    /*
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            String temp=s;
            s=t;
            t=temp;
        }
        if (s.length()>=t.length()+2) return false;
        if (s.length()==t.length()) {
            int diff=0;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i)!=t.charAt(i)) diff++;
                if (diff>1) return false;
            }
            return diff==1;
        } else {
            int i=0, j=0;
            for (i=0,j=0; i<s.length(); i++) {
                if (s.charAt(i)!=t.charAt(j)) {
                    if (i>j+1) return false;
                } else {
                    j++;
                    System.out.print("j:" + j);
                    if (j==t.length()) return true;
                }
            }
            return false;
        }
    }
}