class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        
        int count = lenA >= lenB ? lenA:lenB;
        int value = 0;
        int carry = 0;
        String s = "";
        while(count > 0) {
            if (lenA > 0 && lenB > 0) {
                value = Character.getNumericValue(a.charAt(lenA - 1))
                    + Character.getNumericValue(b.charAt(lenB - 1))
                    + carry;
                
                lenA--;
                lenB--;
                
            } else {
                if (lenA > 0) {
                    value = Character.getNumericValue(a.charAt(lenA - 1))+ carry;
                    lenA--;
                } 
                if (lenB > 0) {
                    value = Character.getNumericValue(b.charAt(lenB - 1))+ carry;
                    lenB--;
                }
            }
            
            if (value == 3) {
                carry = 1;
                s = "1" + s;
            } else if (value == 2) {
                carry = 1;
                s = "0" + s;
            } else if (value == 1) {
                carry = 0;
                s = "1" + s;
            } else {
                carry = 0;
                s = "0" + s;
            }   
            count--;
        }
        
        if (carry == 1) {
            s = "1" + s;
        }
        return s;
    }
}