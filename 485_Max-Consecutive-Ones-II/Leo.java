public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroNum = 2;
        int head = -1, tail = -1, size = nums.length;
        while (++tail < size) {
            if (0 == nums[tail] && 0 > --zeroNum) break;
        }
        int ret = tail;
        while (tail < size) {
            while (++head < tail && nums[head] != 0) ;
            while (++tail < size && nums[tail] != 0);
            ret = Math.max(ret, tail - head - 1);
        }

        return ret;
    }
}
