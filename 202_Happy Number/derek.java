class Solution {
    public boolean isHappy(int n) {
        if (1 == n) return true;
        int slow, fast;
        slow = fast = n;
        do {
            slow = squreSum(slow);
            fast = squreSum(fast);
            fast = squreSum(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        return false;
    }
    private int squreSum(int x) {
        int result = 0, temp = 0;
        while (x != 0) {
            temp = x % 10;
            result += temp*temp;
            x /= 10;
        }
        return result;
    }
}
