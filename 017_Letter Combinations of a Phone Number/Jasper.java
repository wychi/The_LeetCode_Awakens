class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> ans = new LinkedList<>();
        ans.offer("");        
        for(int i=0;i<digits.length();i++) {
            int val = digits.charAt(i) - '0';
            while(ans.peek().length() == i) {
                String s = ans.poll();
                for(char c:mapping[val].toCharArray()) {
                    ans.offer(s+c);
                }
            }
        }
        
        if(ans.peek().length() == 0) {
            ans.poll();
        }
        
        return ans;
    }
    
    
    public List<String> letterCombinations2(String digits) {
        List<String> ret = new ArrayList<>();
        bt(ret, digits, 0, "");
        return ret;
    }
    
    private void bt(List<String> ret, String digits, int index, String tmp) {
        
        if(index == digits.length()) {
            if(tmp.length() > 0) {
                ret.add(tmp);
            }
            return;
        }
        
        String possibleLetter = digitToLetterMap(digits.charAt(index));
        
        for(int i=0;i<possibleLetter.length();i++) {
            bt(ret, digits, index+1, tmp + possibleLetter.charAt(i));
        }
        
    }
    
    private String digitToLetterMap(char num) {
        switch(num) {            
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':  
                return "tuv";
            case '9':
                return "wxyz";                
            case '0':
            case '1':
            default:                
                return "";    
        }
    }
}