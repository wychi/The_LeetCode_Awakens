public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> ret = new LinkedList<>();
        for (int i = 0, last = nums.length - 1; i <= last; i++) {
            if (i > 0 && nums[i-1] == nums[i]) continue;
            int l = i + 1, h = last;
            while (l < h) {
                int v = nums[l] + nums[h] + nums[i];
                if (v > 0) {
                    h--;
                } else if (v < 0) {
                    l++;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[--h] == nums[h+1]);
                }
            }
        }
        return ret;
    }
}
