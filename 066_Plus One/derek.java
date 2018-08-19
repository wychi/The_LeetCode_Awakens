//Time: O(N)
//Space: O(N)
class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {            
            if (carry + digits[i] >= 10) {
                result[i] = 0;
                carry = 1;
            } else {
                result[i] = carry + digits[i];
                carry = 0;
            }
        }
        if (carry != 0) {
            int[] result2 = new int[result.length+1];
            for (int i = 0 ; i<result2.length; i++) {
                if (i==0) result2[i] = 1;
                else result2[i] = result[i-1];
                return result2;
            } 
        }
        return result;
    }
}
