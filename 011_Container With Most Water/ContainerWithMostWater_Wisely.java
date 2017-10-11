class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int max = 0;
        do {
            max = Math.max(max, Math.min(height[first], height[last]) * (last - first));
            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        } while (first < last);
        return max;
    }
}