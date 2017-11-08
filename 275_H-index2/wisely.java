class Solution {
    public int hIndex(int[] citations) {
        for (int i=citations.length; i>=1; i--) {
            int index = citations.length-i;
            if (citations[index]>=i) return i;
        }
        return 0;
    }
}