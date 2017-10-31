class Solution {
    
    public String addBinary(String a, String b) {
        
        int carry = 0;
        int i = a.length() - 1;  
        int j = b.length() - 1; 
        
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j>= 0) {
            
            int bitA = i >= 0 ?  (a.charAt(i) - '0') : 0;  
            int bitB = j >= 0 ? (b.charAt(j) - '0') : 0;   
            
            int sum = carry + bitA + bitB; // 2
            
            carry = sum / 2; 
            sb.append(sum % 2);                     
            i--;
            j--;
        }
        
        if(carry >0) {
            sb.append(carry);  
        }
        
        return sb.reverse().toString();
    }
}