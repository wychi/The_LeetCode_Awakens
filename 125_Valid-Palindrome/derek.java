class Solution {
    //Key:
    //1. Remove other character (not 0-9, a-z, A-Z)  , API:
    //
    
    //Time:  O(N)
    //Space: O(N)
    public boolean isPalindrome(String s) {
        int len = null != s ? s.length() : 0;
        if (len <= 0) return true;
        StringBuilder sb = new StringBuilder();
        //remove other character
        for (char c: s.toCharArray()) {
            if ((c>='A' && c<='Z')
                    || (c >='a' && c<='z')
                    || (c>='0' && c<='9')) {
                sb.append(c);
            }
        }
        final String result = sb.toString().toLowerCase();
        // System.out.println("1:"+result);
        len = null != result ? result.length() : 0;
        if (len <= 1) return true;
        
        int start = 0, end = len - 1;
        while (start < end) {
            // System.out.println("2:"+result.charAt(start)+", ::"+result.charAt(end));
            if (result.charAt(start) != result.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
