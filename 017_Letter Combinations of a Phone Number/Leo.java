class Solution {
    private String[] ST = {"0", "1", "abc", 
                                     "def", "ghi", "jkl", 
                                     "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        LinkedList<String> base = new LinkedList<>();
        for (int i = 0, size = digits.length(); i < size ; i++) {
            base.add(ST[digits.charAt(i) - '0']);
        }
        LinkedList<String> ret = new LinkedList<>();
        if (digits.length() == 0) return ret;
        ret.add("");
        for (String s:base) {
            for (int i = 0, size = ret.size(); i < size; i++) {
                String b = ret.removeFirst();
                for (int j = 0, sizeJ = s.length(); j < sizeJ; j++) {
                    ret.add(b+s.charAt(j));
                }
            }
        }
        return ret;
    }
}
