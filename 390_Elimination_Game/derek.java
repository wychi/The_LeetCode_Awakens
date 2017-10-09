class Solution {
    //Method 1: Use array that may lead to memory limitation
    //Method 2: Try to find number relationship
    // public int lastRemaining(int n) {
    //     boolean left = true;
    //     int remaining = n;
    //     int step = 1;
    //     int head = 1;
    //     while (remaining > 1) {
    //         if (left || remaining % 2 ==1) {
    //             head = head + step;
    //         }
    //         remaining = remaining / 2;
    //         step = step * 2;
    //         left = !left;
    //     }
    //     return head;
    // }
    
    //Method 3:
    public int lastRemaining(int n) {
        return L2R(n);
    }
    
    private int L2R(int n) {
        if (n <= 2) {
            return n;
        }
        return 2 * R2L(n/2);
    }
    
    private int R2L(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n % 2 == 1) {
            return 2 * L2R(n/2);
        } else {
            return 2 * L2R(n/2) - 1;
        }
    }
}
