class Solution {
    public String largestNumber(int[] nums) {
        final int len = null != nums ? nums.length : 0;
        if (len <= 0) return "";
        
        String[] strArray = new String[len];
        int i = 0;
        for (int n: nums) {
            strArray[i++] = String.valueOf(n);
        }
        
        Arrays.sort(strArray, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String a = s1 + s2;
                String b = s2 + s1;
                return b.compareTo(a);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        String s = "";
        for (i = 0 ; i<strArray.length; i++) {
            s = strArray[i];
            if (0 == i) {
                sb.append(s);
            } else {
                if (!"0".equals(s)) {
                    sb.append(s);
                } else if (!"0".equals(strArray[0])) {
                    sb.append(s);
                }
            }
        
        }
        
        return sb.toString();
    }
}
