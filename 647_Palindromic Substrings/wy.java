class Solution {
    public int countSubstrings(String s) {
        
        int total = 0;
        for(int i=0;i<s.length();i++) {
            int n1 = countSubstrings(s, i, i);
            int n2 = countSubstrings(s, i, i+1);

            total += n1 + n2;
        }
        
        return total;
        
    }
    
    public int countSubstrings(String s, int left, int right) {
        
        int count = 0;
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }
    
}
