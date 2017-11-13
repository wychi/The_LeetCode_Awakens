class Solution {
    //[1]
    //[100]
    
    //Time: O(NlogN)
    //Space: O(1)
    // public int hIndex(int[] citations) {
    //     Arrays.sort(citations);
    //     final int len = null != citations ? citations.length : 0;
    //     for (int i = 0; i<len; i++) {
    //         if (citations[i] >= len - i) {
    //             return len-i;
    //         }
    //     }
    //     return 0;
    // }
    
    //Time: O(N)
    //Space: O(N)
    public int hIndex(int[] citations) {
        final int len = null != citations ? citations.length: 0;
        int[] count = new int[len+1];
        for (int i = 0 ; i<len; i++) {
            if (citations[i] >= len) {
                count[len]++;
            } else {
                count[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = len; i>=0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
