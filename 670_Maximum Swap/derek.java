class Solution {
    //Time:O(N)
    //Space:O(N)
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        
        int[] buckets = new int[10];
        for (int i = 0 ; i< digits.length; i++) {
            buckets[digits[i]-'0'] = i;
        }
        
        for (int i = 0; i<digits.length; i++) {
            for (int k = 9; k>digits[i]-'0' ; k--) {
                if (buckets[k] > i) {
                    int temp = digits[i]-'0';
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = (char) (temp+'0');
                    return Integer.valueOf(String.valueOf(digits));
                }
            }
        }
        return num;
    }
}
