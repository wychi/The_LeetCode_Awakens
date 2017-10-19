class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while(i<j) {
            if(!isAlphabat(s.charAt(i))) {
                i++;
            } else if(!isAlphabat(s.charAt(j))) {
                j--;
            } else {
                if(s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    boolean isAlphabat(Character c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
