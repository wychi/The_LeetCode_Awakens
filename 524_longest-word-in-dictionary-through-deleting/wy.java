class Solution {
    public String findLongestWord(String s, List<String> d) {

        // Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
        
        String ret = "";
        for(String str : d) {
            int j = 0;
            for(int i=0;i<s.length() && j <str.length(); i++) {
                if(str.charAt(j) == s.charAt(i)) {
                    j++;
                }
            }
            
            if(j == str.length()) {
                if(ret.length() < j || (ret.length() == j && ret.compareTo(str) > 0)) {
                    ret = str;
                }
            }
        }
        
        return ret;
    }
}
