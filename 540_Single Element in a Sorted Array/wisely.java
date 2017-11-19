class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length==1) return nums[0];
        int l=0, r=nums.length-1;
        while(l<r) {
            int m=l+(r-l)/2;
            if (r-l==2) {
                if (nums[m]==nums[l]) return nums[r];
                else return nums[l];
            }
            boolean odd=m%2==0;
            if (nums[m]==nums[m-1]) {
                if (odd) r=m;
                else l=m+1;
            } else {
                if (odd) l=m;
                else r=m-1;
            }
        }
        return -1;
    }
}