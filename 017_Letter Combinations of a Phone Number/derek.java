class Solution {

	//Beats 99%
	class Solution {
    private static final String[] MAP = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (null == digits || digits.length() <= 0) return result;
        helper(result, digits, "", 0);
        return result;
    }

    private void helper(List<String> result, String digits, String substring, int start) {
        if (substring.length() == digits.length()) {
            result.add(String.valueOf(substring));
            return;
        }
        String temp = MAP[digits.charAt(start)-'0'];
        for (int i = 0 ; i<temp.length(); i++) {
            helper(result, digits, substring+temp.charAt(i), start+1);
        }
    }
}

	//Bad performace!!
	class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<String>();
        if (null == digits || digits.length() <= 0)
            return result;

        List<String> base = new ArrayList<>();
        for (int i = 0 ; i<digits.length() ; i++) {
            base.add(map[digits.charAt(i)-'0']);
        }

        result.add("");
        for (String s : base) {
            for (int i = 0, size=result.size() ; i<size; i++) {
                String b = result.removeFirst();
                for (char c: s.toCharArray()) {
                    result.add(b+c);
                }
            }
        }
        return result;
    }
}
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
