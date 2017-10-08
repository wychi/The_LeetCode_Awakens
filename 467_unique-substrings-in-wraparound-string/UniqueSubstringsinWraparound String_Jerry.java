class Solution {
    
    public int findSubstringInWraproundString(String p) {
        // record to end chars
        int [] count = new int[26];
        int len = 0;
        
        for(int i=0; i< p.length(); i++) {
            if (i == 0) {
                len = 1;
            } else {
                int diff = p.charAt(i) - p.charAt(i-1);
                // + 1 (ab) or -25(za)
                if (diff == 1 || diff == ('a'-'z')) {
                    len++;
                } else {
                    len = 1;                    
                }
            }
            
            int endIndex = p.charAt(i)-'a';
            count[endIndex] = Math.max(count[endIndex], len);
        }
        
        int sum = 0;
        for (int n: count) {
            sum += n;
        }
        return sum;
    }
    
    // TLE
    public int findSubstringInWraproundString_old(String p) {
        char lastChar;
        Set<String> distinstSet = new HashSet<>();
        
        for(int i=0; i< p.length(); i++) {
            //single one
            lastChar = p.charAt(i);
            distinstSet.add(String.valueOf(lastChar));
            
            StringBuilder sb = new StringBuilder(String.valueOf(lastChar));
            for(int j=i+1; j< p.length();j++) {
                int diff = p.charAt(j) - lastChar;
                
                // + 1 (ab) or -25(za)
                if (diff == 1 || diff == ('a'-'z')) {
                    lastChar = p.charAt(j);
                    sb.append(String.valueOf(lastChar));
                    distinstSet.add(sb.toString());
                } else {
                    break;
                }               
            }
        }
        
        return distinstSet.size();
    }
}