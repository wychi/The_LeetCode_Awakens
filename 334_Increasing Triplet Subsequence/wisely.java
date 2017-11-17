class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer m1 = null, m2 = null;
        for (int num : nums) {
            if (m1 != null && m2 != null && num > m2) {
                return true;
            }
            if (m1 == null || num < m1) {
                m1 = num;
            } else if (m1 != null && num > m1 && (m2 == null || num < m2)) {
                m2 = num;
            }
        }
        return false;
    }
}