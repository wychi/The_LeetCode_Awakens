public class Solution {
    public String reverseWords(String s) {
        if (null == s || s.length() <= 0) {
            return s;
        }
        String[] array = s.trim().split(" ");
        if (array == null || array.length <= 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = array.length-1 ; i>0; i--) {
            if (null == array[i] || array[i].length() <= 0) continue;
            sb.append(array[i]).append(" ");
        }
        return sb.append(array[0]).toString();
    }
}


public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        s = s.trim();
        char c;
        for (int i = s.length()-1; i>=0 ; i--) {
            c = s.charAt(i);
            if (' ' != c) {
                sb.append(c);
            } else if (null == sb.toString() || sb.toString().length() > 0) {
                result.append(sb.reverse().toString());
                sb = new StringBuilder();
                if (i != 0) {
                    result.append(" ");
                }
            }
        }
        result.append(sb.reverse().toString());
        return result.toString();
    }
}
