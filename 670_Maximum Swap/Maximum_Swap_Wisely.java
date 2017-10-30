class Solution {
    public int maximumSwap(int num) {
        char[] cns = Integer.toString(num).toCharArray();
        int[] pos = new int[10];
        for (int i = 0; i < cns.length; i++) {
            pos[cns[i]-'0'] = i;
        }
        for (int i = 0; i < cns.length; i++) {
            for (int j=9; j>cns[i] - '0'; j--) {
                if (pos[j] > i) {
                    char temp = cns[i];
                    cns[i] = cns[pos[j]];
                    cns[pos[j]] = temp;
                    return Integer.parseInt(new String(cns));
                }
            }
        }
        return num;
    }
}