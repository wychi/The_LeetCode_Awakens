/*
 *Use counting sort, its advantage is easy to extend if we have more colors.
 *Time : O(n)
 *Space: numbers of Color k, O(k). if k is constant, O(1)
 */

public class Solution {
  private static final int COLOR_NUMBER = 3;
  public void sortColors(int[] nums) {
        int[] counts = new int[COLOR_NUMBER];
        for (int v: nums) counts[v]++;
        for (int color = 0, idx = 0; color < COLOR_NUMBER; color++) {
            int c = counts[color];
            while (c-->0) nums[idx++] = color;
        }
    }
  }
  public void sortColors(int[] nums) {
        int i = 0, l = 0, h = nums.length-1; //2,1,2
        while (i <= h) {
            if (nums[i] == 0)  {
                nums[i++] = nums[l];
                nums[l++] = 0;
            } else if (nums[i] == 2) {
                nums[i] = nums[h];
                nums[h--] = 2;
            } else {
                i++;
            }
        }
    }
}
