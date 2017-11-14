class Solution {
    public String multiply(String num1, String num2) {
        
        int n1 = num1.length();
        int n2 = num2.length();
        int[] tmp = new int[n1*n2+1];
        
        int offset = 0;
        for(int i=n1-1;i>=0;i--) {
            int v1 = num1.charAt(i) - '0';
            for(int j=n2-1; j>=0; j--) {
                int v2 = num2.charAt(j) - '0';
                tmp[n2-j-1 + offset] += v1 * v2;
            }
            offset++;
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int mostIdx = 0;
        for(int i=0; i<tmp.length; i++) {
            int val = carry + tmp[i];
            tmp[i] = val % 10;
            carry = val / 10;
            
            if(tmp[i] != 0) {
                mostIdx = i;
            }
        }
        
        for(int i=mostIdx; i>=0;i--) {
            sb.append(tmp[i]);
        }
        
        return sb.toString();
        
    }
}
