//time O(n), space O(n)
class Solution {
    public int hIndex(int[] cs) {
        if (cs == null || cs.length == 0) return 0;
        int[] count = new int[cs.length + 1];
        for (int c : cs) {
            count[c >= cs.length ? cs.length : c]++;
        }
        int total = 0;
        for (int i = cs.length; i >= 0; i--) {
            total += count[i];
            if (total >= i) return i;
        }
        return 0;
    }
}
//time O(nlogn), space O(1)
/*class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = n; i > 0; i--) {
            if (citations[n-i] >= i) return i;
        }
        return 0;
    }
}*/