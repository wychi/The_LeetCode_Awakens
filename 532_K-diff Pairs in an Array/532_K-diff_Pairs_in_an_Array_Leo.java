class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        final Integer EXIST = 0;
        final Integer HAS_PAIR = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int v:nums) {
            if (EXIST == map.get(v - k)) {
                ret++;
                map.put(v - k, HAS_PAIR);
            }
            if (map.get(v) == null) {
                if (null != map.get(v + k)) {
                    ret++;
                    map.put(v, HAS_PAIR);
                } else {
                    map.put(v, EXIST);
                }
            }
        }
        return ret;
    }
}
