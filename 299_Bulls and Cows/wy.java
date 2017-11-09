class Solution {
    public String getHint(String secret, String guess) {
        int[] digits = new int[10];
        int nA = 0;
        int nB = 0;
        for(int i=0; i<secret.length(); i++) {
            int sv = secret.charAt(i) - '0';
            int gv = guess.charAt(i) - '0';
            if(sv == gv) {
                nA++;
            } else {
                if(digits[sv] < 0 ) {
                    nB++;
                }
                digits[sv]++;
                
                if(digits[gv] > 0 ) {
                    nB++;
                }
                digits[gv]--;
            }
        }
        return nA + "A" + nB + "B";
    }
}
