class Solution {
    public int maxProduct(String[] words) {
        if (words==null || words.length<2) return 0;
        int l = words.length;
        int[] values = new int[l];
        int index = 0;
        for (String word : words) {
            values[index] = wti(word);
            index++;
        }
        int max = 0;
        for (int i=0; i<l; i++) {
            for (int j=i+1; j<l; j++) {
                if ((values[i]&values[j])==0) max = Math.max(max, words[i].length()*words[j].length());
            }
        }
        return max;
    }
    
    private int wti(String word) {
        int r = 0;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            r |= (1<<(c-'a'));
            //System.out.println("" + r);
        }
        return r;
    }
}