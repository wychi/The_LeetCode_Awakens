//Time:O(N)
//Space:O(N)
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, max = 0;
        for (int i = 0 ; i<nums.length; i++) {
            sum+=nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum-k)) {
                max = Math.max(max, i - map.get(sum-k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}

public class Solution {
  public int maxSubArrayLen(int[] nums, int k) {
	if (nums==null || nums.length==0) return 0;
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	map.put(0, -1);
	int sum = 0;
	int maxLen = Integer.MIN_VALUE;
	for (int i=0; i<nums.length; i++) {
	  sum += nums[i];
	  if (!map.containsKey(sum)) {
		map.put(sum, i);
	  }
	  if (map.containsKey(sum-k)) {
		int index = map.get(sum-k);
		maxLen = Math.max(maxLen, i-index);
	  }
	}
	return maxLen==Integer.MIN_VALUE? 0 : maxLen;
  }
}
