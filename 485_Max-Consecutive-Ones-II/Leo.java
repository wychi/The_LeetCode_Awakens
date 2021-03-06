public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroNum = 1;
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
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroNum = 1;
        int tail = -1, size = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        while (++tail < size) {
            if (0 == nums[tail]) {
                list.add(tail);
                if (0 > --zeroNum) break;
            }
        }
        int ret = tail;
        while (tail < size) {
            while (++tail < size && nums[tail] != 0);
            list.add(tail);
            ret = Math.max(ret, tail - list.removeFirst() - 1);
        }

        return ret;
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        for (int l = -1, h = 0, last = -1, zeors = 1; h < nums.length ; h++) {
            if (0 == nums[h])  {
                l = last;
                last = h;
            }
            int v = h - l - 1;
            if (ret < v) ret = v;
        }
        return ret;
    }
}
