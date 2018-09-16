//Time: O(M+N)
//Space:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i: nums1) {
            set.add(i);
        }
        for (int i = 0 ; i<nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for (int i : res) {
            ans[idx++] = i;
        }
        return ans;
    }
}
