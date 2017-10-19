class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        bt(n, 0, 0, sb, result);
        
        return result;
    }
    
    void bt(int n, int open, int close, StringBuilder sb, List<String> result) {
        if(n*2 == sb.length()) {
            result.add(sb.toString());
            return;
        }
        
        if(n > open) {
            sb.append("(");
            bt(n, open+1, close, sb, result);
            sb.setLength(sb.length() - 1);
        }
        
        if(open > close) {
            sb.append(")");
            bt(n, open, close+1, sb, result);
            sb.setLength(sb.length() - 1);
        }
    }
    
}
