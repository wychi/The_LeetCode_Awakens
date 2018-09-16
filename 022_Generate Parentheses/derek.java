class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n<=0) {
            return result;
        }
        generateAll(result, "", 0, 0, n);
        return result;
    }
    
    private void generateAll(List<String> result, String curr, int openingBrackets, int closingBrackets, int max) {
        if (curr.length() == max*2) {
            result.add(curr);
            return;
        }
        if (openingBrackets < max) {
            generateAll(result, curr+"(", openingBrackets+1, closingBrackets, max);
        }
        if (closingBrackets < openingBrackets) {
            generateAll(result, curr+")", openingBrackets, closingBrackets+1, max);
        }
    }
}
