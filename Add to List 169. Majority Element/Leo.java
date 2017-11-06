public class Solution {
/* time: O(n*ln(n)) 
   space: O(n)/O(1)
*/
    public int majorityElement(int[] nums) {
     Arrays.sort(nums);
     return nums[nums.length/2];
    }
/* time: O(n) 
   space: O(n)
*/
  public int majorityElement(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>(nums.length);
      int l = nums.length/2;
      for (int n:nums) {
          int v = map.getOrDefault(n, 0)+1;
          if (v>l) return n;
          map.put(n, v);
      }
      return 0;
  }
    
/* time: O(n) 
   space: O(1)
*/   
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 0;
        for (int v: nums) {
            count += (v == major) ? 1: -1;
            if (count == 0) {
                major = v;
                count = 1;
            }
        }
        return major;
    }
}
