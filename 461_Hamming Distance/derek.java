class Solution {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int answer = 0;
        while (result > 0) {
            if ((result & 1) == 1) {
                answer++;
            }
            result >>>= 1;
        }
        return answer;
    }
}
