class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] num_letters = {
            {}, {},
            {'a','b','c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        
        List<String> result = new ArrayList<>();
        if(digits.length() > 0)
            bt(num_letters, digits, 0, new StringBuilder(), result);
        return result;
    }
    
    void bt(char[][] num_letters, String digits, int idx, StringBuilder sb, List<String> result) {
        
        if(idx ==digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        int val = digits.charAt(idx) -'0';
        char[] letters = num_letters[val];
        for(char c : letters) {
            sb.append(c);
            bt(num_letters, digits, idx+1, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }

}
