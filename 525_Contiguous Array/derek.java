class Solution {
    //Time:  O(N)
    //Space: O(1)
    public int findMaxLength(int[] nums) {
        final int size = null != nums ? nums.length : 0;
        if (size <= 0) return 0;
        int zeroCnt = 0, oneCnt = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0 ; i<size; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            
            if (map.containsKey(zeroCnt-oneCnt)) {
                max = Math.max(max, i-map.get(zeroCnt-oneCnt));
            } else {
                map.put((zeroCnt-oneCnt), i);
            }
        }
        return max;
    }
}
