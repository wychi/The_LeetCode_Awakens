    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0, current = 0;
        boolean meetZero = false;
        for (int v: nums) {
            if (0 == v) {
                if (meetZero) {
                    current = 0;
                    continue;
                }
                meetZero = true;
            }
            if (++current > ret) ret = current;
        }
        return ret;
    }
