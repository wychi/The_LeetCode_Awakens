    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer idx = map.get(sum - k);
            if (null != idx) {
              ret = Math.max(ret, i - idx);
            } else if (!map.containsKey(i)) {
              map.put(i, sum);
            }
        }
        return ret;
    }
