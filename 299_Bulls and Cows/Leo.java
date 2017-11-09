class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0, len = secret.length();
        int[] map = new int[10];
        for (int i = 0; i < len ; i++) {
            char cs = secret.charAt(i);
            char cg = guess.charAt(i);
            if (cs == cg) {
                bull++;
            } else {
                mapS[cs-'0']++;
                mapG[cg-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cow += Math.min(mapS[i], mapG[i]);
        }
        return ""+bull+"A"+cow+"B";
    }
}
