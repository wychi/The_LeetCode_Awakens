class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(); int l2 = num2.length();
        int[] nums = new int[l1+l2];
        for (int i=0; i<l1; i++) {
            for (int j=0; j<l2; j++) {
                nums[i+j] += ((num1.charAt(i)-'0') * (num2.charAt(j)-'0'));
            }
        }
        String result = "";
        int add=0;
        for (int i=l1+l2-2; i>=0; i--) {
            int v = nums[i]+add;
            System.out.print("" + i + "," + v);
            result = "" + (v%10) + result;
            add=v/10;
        }
        if (result.length() == 0) result = "0";
        result = add > 0 ? "" + add + result : result;
        int i=0;
        for (i=0; i<result.length()-1; i++) {
            if (result.charAt(i)!='0') {
                break;
            }
        }
        return result.substring(i, result.length());
    }
    /*public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        String result = "0";
        String temp = "";
        for (int i = num2.length() -1; i>=0; i--) {
            String r = mul(num1, num2.charAt(i)-'0') + temp;
            result = add(result, r);
            temp = temp + "0";
        }
        return result;
    }
    
    private String mul(String num1, int m) {
        if (m==0) return "0";
        if (m==1) return num1;
        String result = "";
        int add = 0;
        for (int i = num1.length()-1; i>=0; i--) {
            int c = num1.charAt(i) - '0';
            int v = c * m + add;
            result = "" + (v % 10) + result;
            add = v / 10;
        }
        return add == 0 ? result : "" + add + result;
    }
    
    private String add(String num1, String num2) {
        String result = "";
        int add = 0;
        int l1 = num1.length()-1; int l2 = num2.length()-1;
        while(l1>=0 || l2>=0) {
            int v1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int v2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int v = v1+v2+add;
            result = "" + (v % 10) + result;
            add = v / 10;
            l1--; l2--;
        }
        return add == 0 ? result : "" + add + result;
    }*/
}