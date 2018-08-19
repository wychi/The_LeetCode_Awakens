//Like moving zero
//TIme:O(N)
//Spae:O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        int head=0;
        for (int tail = 0 ; tail < nums.length; tail++) {
            if (nums[tail] != val) {
                nums[head] = nums[tail];
                head++;
            }
        }
        return head;
    }
}
