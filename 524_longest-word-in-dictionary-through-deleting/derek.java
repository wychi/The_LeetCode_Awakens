class Solution {
    public String findLongestWord(String s, List<String> d) {
        if (null == s || s.length() <= 0) {
            return "";
        }
        if (null == d || d.size() <= 0) {
            return "";
        }
        
        //Method 1 : Sort dictionary longest to shortest and lexicographical
//         Collections.sort(d, new Comparator<String>() {
//             public int compare(String a, String b) {
//                 return a.length() != b.length()
//                     ? -Integer.compare(a.length(), b.length())
//                     : a.compareTo(b);
//             }
//         });
        
//         int dictIdx = 0;
//         for (String dictStr: d) {
//             dictIdx = 0;
//             for (int i = 0 ; i < s.length() ; i++) {
//                 if (dictIdx < dictStr.length()
//                     && s.charAt(i) == dictStr.charAt(dictIdx)) {
//                     dictIdx++;
//                 }
//             }
//             if (dictIdx == dictStr.length()) {
//                 return dictStr;
//             }
//         }
//         return "";
        
        //Method 2: Without sort dictionary
        int dictIdx = 0;
        String longestStr = "";
        for (String dictStr: d) {
            dictIdx = 0;
            for (int i = 0 ; i < s.length() ; i++) {
                if (dictIdx < dictStr.length()
                        && s.charAt(i) == dictStr.charAt(dictIdx)) {
                    dictIdx++;
                }
            }
            if (dictIdx == dictStr.length()) {
                if (dictStr.length() > longestStr.length()
                        || dictStr.compareTo(longestStr)) {
                    longestStr = dictStr;
                }
            }
        }
        return "";
    }
}
