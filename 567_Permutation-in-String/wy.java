class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        
        char[] charArray1 = s1.toCharArray();
        int[] letters = new int[26];
        for(int i=0;i<charArray1.length; i++) {
            int idx = charArray1[i] - 'a';
            letters[idx]++;
        }

        for(int i=0; i<s2.length() - s1.length() +1; i++) {
            
            if(letters[s2.charAt(i) - 'a'] == 0)
                continue;
            
            int[] tmp = Arrays.copyOf(letters, 26);
            boolean found = true;
            for(int j=i; j<s1.length()+i; j++) {
                int idx = s2.charAt(j) - 'a';
                tmp[idx]--;
                if(tmp[idx]<0) {
                    found = false;
                    break;
                }
            }
            if(found)
                return true;
        }
        
        
        return false;
    }
}
