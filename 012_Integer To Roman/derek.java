//Time:O(1)
//Space:O(1)
class Solution {
    private int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    public String intToRoman(int num) {
        if (num <= 0) return "";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i<values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
    
}
