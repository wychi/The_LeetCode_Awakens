class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dps=new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word1.length(); i++) {
            for (int j=0; j<word2.length(); j++) {
                if (word1.charAt(i)==word2.charAt(j)) {
                    dps[i+1][j+1]=dps[i][j]+1;
                } else {
                    dps[i+1][j+1]=Math.max(dps[i+1][j], dps[i][j+1]);
                }
            }
        }
        int v = dps[word1.length()][word2.length()];
        return word1.length()-v+word2.length()-v;
    }
}