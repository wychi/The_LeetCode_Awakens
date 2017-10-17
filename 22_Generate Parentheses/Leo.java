class Solution {
    private void generateParenthesis(LinkedList<String> ret, char[] paren, int idx, int left, int right) {
        if (paren.length == idx) {
            ret.add(new String(paren));
            return;
        }
        if (left < paren.length/2) {
            paren[idx] = '(';
            generateParenthesis(ret, paren, idx+1, left+1, right);
        }
        if (right < left) {
            paren[idx] = ')';
            generateParenthesis(ret, paren, idx+1, left, right+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        LinkedList<String> ret = new LinkedList<>();
        generateParenthesis(ret, new char[n*2], 0, 0, 0);
        return ret;
    }
    
    public List<String> generateParenthesis(int n) {
        n <<= 1;
        LinkedList<String> ret = new LinkedList<>();
        int left = 0, right = 0, idx = 0;
        char[] paren = new char[n];
        while (idx >= 0) {
            if (left < paren.length/2) {
                paren[idx++] = '(';
                left++;
            } else if (right < left) {
                paren[idx++] = ')';
                right++;
            } else {
                if (idx == n) ret.add(new String(paren));
                while (--idx >= 0 ) {
                    if (paren[idx] == ')') {
                        right--;
                    } else {
                        left--;
                        if (left > right) {
                           right++;
                           paren[idx++] = ')'; 
                           break;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
