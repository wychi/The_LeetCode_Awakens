class Solution {
    
    public int romanToInt(String s) {
        int[] sum = new int[s.length()];
        char x;
        for (int i = 0; i<s.length(); i++) {
            x = s.charAt(i);
            sum[i] = getRamoanInt(String.valueOf(s.charAt(i)));
        }
        int result = 0;
        for (int i = 0 ; i<sum.length-1; i++) {
            if (sum[i] < sum[i+1]) {
                result -= sum[i];
            } else {
                result += sum[i];
            }
        }
        return result + sum[sum.length-1];
    }
    
    private int getRamoanInt(String x) {
        if ("I".equals(x)) return 1;
        else if ("V".equals(x)) return 5;
        else if ("X".equals(x)) return 10;
        else if ("L".equals(x)) return 50;
        else if ("C".equals(x)) return 100;
        else if ("D".equals(x)) return 500;
        else if ("M".equals(x)) return 1000;
        return 0;
    }
}
