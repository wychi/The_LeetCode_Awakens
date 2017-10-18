class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();        
        backtrack(output, sb, n, n);    
        return output;
    }
    
    private void backtrack(List<String> output, StringBuilder sb, int leftCount, int rightCount) {
        
        if(leftCount == 0 && rightCount == 0) {
            output.add(sb.toString());
            return;
        }
        
        if(leftCount > 0) {
            sb.append("(");
            backtrack(output, sb, leftCount-1, rightCount);
            sb.deleteCharAt(sb.lastIndexOf("("));
        }
        
        if(rightCount > leftCount) {
            sb.append(")");
            backtrack(output, sb, leftCount, rightCount-1);
            sb.deleteCharAt(sb.lastIndexOf(")"));
        }
                
    }
}