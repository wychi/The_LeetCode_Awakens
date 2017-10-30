class Solution {
    //Pass, but performance is bad !!!
    // public List<String> letterCombinations(String digits) {
    //     final int len = null != digits ? digits.length() : 0;
    //     final LinkedList<String> result = new LinkedList<String>();
    //     if (len <= 0) {
    //         return result;
    //     }
    //     final String[] keyMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //     String temp = "";
    //     result.add(temp);
    //     int size = 1;
    //     for (char c: digits.toCharArray()) {
    //         System.out.println("c:"+c);
    //         for (int i = 0 ; i<size; i++) {
    //             temp = result.remove();
    //             System.out.println("temp:"+temp);
    //             for (char keyChar: keyMap[c-'0'].toCharArray()) {
    //                 System.out.println("temp:"+temp+", keyChar:"+keyChar);
    //                 result.add(temp+keyChar);
    //             }
    //         }
    //         size = result.size();
    //     }
    //     return result;
    // }
    public List<String> letterCombinations(String digits) {
        
        LinkedList<String> result = new LinkedList<String>();
        if (null == digits || digits.length() <= 0) {
            return result;
        }
        final String[] keyMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        int x = 0;
        for (int i = 0; i<digits.length(); i++) {
            x = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String t = result.remove();
                for (char s: keyMap[x].toCharArray()) {
                    result.add(t+s);
                }
            }
        }
        return result;
    }
}
