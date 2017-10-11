class Solution {
    public int maxArea(int[] height) {
        int l = 0, h = height.length - 1, ret = 0;
        while (l < h) {
            int newArea = (height[l] < height[h] ? height[l] : height[h]) * (h - l);
            if (ret < newArea) ret = newArea;
            if (height[l] < height[h]) {
                l++;
            } else {
                h--;
            }
        }
        return ret;
    }
}
