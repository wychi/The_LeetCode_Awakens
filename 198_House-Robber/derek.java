//Method: Dynamic Programming
//TIme:O(N)
//Space:O(1)
class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, currMax = 0;
        int temp;
        for (int x: nums) {
            temp = currMax;
            currMax = Math.max(prevMax+x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
