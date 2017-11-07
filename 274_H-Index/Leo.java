class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] counts = new int[len+1];
        for (int v:citations) {
            if (v >= len) {
                counts[len]++;
            } else {
                counts[v]++;
            }
        }
        int sum = 0;
        for (int i = len; i >=0; i--) {
            sum += counts[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}
