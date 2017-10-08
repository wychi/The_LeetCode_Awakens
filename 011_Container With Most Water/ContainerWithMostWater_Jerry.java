class Solution {
    
    // O(N)
    public int maxArea(int[] height) {
        int result = 0;
        int lastHeight = 0;
        
        int left = 0;
        int right = height.length-1;
        while(left < right) {
            if (height[left] < height[right]) {
                // Using left one
                if (height[left] > lastHeight) {
                    result = Math.max(result, (right-left) * height[left]);
                    lastHeight = height[left];
                }
                left++;
            } else {
                // Using right one
                if (height[right] > lastHeight) {
                    result = Math.max(result, (right-left) * height[right]);
                    lastHeight = height[right];
                }
                right--;
            }
        }
        return result;
    }
    
    // TLE: O(N^2)
    public int maxArea_old(int[] height) {
        int result = 0;
        for (int i=0; i < height.length-1 ; i++) {
            int currentY = 0;
            for (int j=height.length-1; j > i; j--) {
                if (height[j] > currentY) {
                    int containerHeight = Math.min(height[i], height[j]);
                    int container = containerHeight * (j-i);
                    if (container  > result) {
                        result = container;
                        currentY = height[j];
                    }
                }
            }
        }
        return result;
    }
}