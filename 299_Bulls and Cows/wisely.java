class Solution {
    public String getHint(String secret, String guess) {
        if (secret.length()==0) return "0A0B";
        int countA=0, countB=0;
        Map<Character, Integer> maps=new HashMap<>();
        String others="";
        for (int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s==g) {
                countA++;
            } else {
                int count=1;
                if (maps.containsKey(s)) count=maps.get(s)+1;
                maps.put(s, count);
                others+=g;
            }
        }
        for (int i=0; i<others.length(); i++) {
            char c = others.charAt(i);
            if (maps.containsKey(c)&&maps.get(c)>0) {
                countB++;
                maps.put(c, maps.get(c)-1);
            }
        }
        return ""+countA+"A"+countB+"B";
    }
}