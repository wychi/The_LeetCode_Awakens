class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) != '-') {
                if (count == k) {
                    count = 0;
                    sb.append("-");
                }
                sb.append(s.charAt(i));
                count++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
