class Solution {
    //Key:
    //nums1[i] * nums2[j] => indices[i+j, i+j+1]
    public String multiply(String num1, String num2) {
        final int len1 = null != num1 ? num1.length() : 0;
        final int len2 = null != num2 ? num2.length() : 0;
        int[] result = new int[len1+len2];
        
        int val1, val2;
        int p1, p2;
        int sum, mul;
        for (int i = len1-1; i>=0; i--) {
            val1 = num1.charAt(i) - '0';
            for (int j = len2-1; j>=0; j--) {
                val2 = num2.charAt(j) - '0';
                p1 = i+j;
                p2 = i+j+1;
                
                mul = val1 * val2;
                sum = mul + result[p2];
                
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<result.length; i++) {
            if (sb.length() != 0 || result[i] !=0 ) {
                sb.append(result[i]);
            }
        }
        
        return sb.length() != 0 ? sb.toString() : "0";
    }
}
