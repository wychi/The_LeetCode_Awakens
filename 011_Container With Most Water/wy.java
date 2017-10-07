class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        
        int max = 0;
        while(i < j) {
            int volumn = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, volumn);
            
            if(height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return max;
    }
}
