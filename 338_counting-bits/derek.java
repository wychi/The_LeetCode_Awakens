//Time: O(NK). For each integer xxx, we need O(k)O(k)O(k) operations where kkk is the number of bits in xxx.
//Space: O(N)
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0;i<=num; i++) {
            result[i] = count1s(i);
        }
        return result;
    }

    private int count1s(int i) {
        int result = 0;
        while (i != 0) {
            result++;
            i &= i-1;
        }
        return result;
    }
}
