class Solution {
    public List<String> letterCombinations(String digits) {
        String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        LinkedList<String> res = new LinkedList<>();
        int count = 1; res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '0';
            String pick = KEYS[c];
            int temp = count;
            while (temp > 0) {
                String s = res.poll();
                temp--;
                for (int j = 0; j < pick.length(); j++) {
                    Ares.offer(s + pick.charAt(j));
                }
            }
            count *= pick.length();
        }
        if (res.size() == 1) res.clear();
        return res;
    }
}