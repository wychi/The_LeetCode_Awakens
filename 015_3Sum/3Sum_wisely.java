// -2, -1, -1, 0, 0, 1, 2, 2
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int temp = 0 - nums[i];
            int f = i + 1, l = nums.length-1;
            while (f < l) {
                if (nums[f] + nums[l] == temp) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]); r.add(nums[f]); r.add(nums[l]);
                    result.add(r);
                    f++; l--;
                } else if (nums[f] + nums[l] > temp) {
                    l--;
                } else {
                    f++;
                }
                while (l < nums.length - 1 && l > f && nums[l] == nums[l + 1]) l--;
                while (f > i + 1 && f < l && nums[f] == nums[f - 1]) f++;
            }
        }
        return result;
    }
}