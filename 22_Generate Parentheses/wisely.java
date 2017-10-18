class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        add("(", result, n-1, n, 1);
        return result;
    }
    
    private void add(String prefix, List<String> result, int left, int right, int current) {
        if (left == 0 && right == 0) {
            result.add(prefix);
            return;
        }
        if (left > 0) {
            add(prefix + "(", result, left-1, right, current+1);
        }
        if (right > 0 && current > 0) {
            add(prefix + ")", result, left, right-1, current-1);
        }
    }
}