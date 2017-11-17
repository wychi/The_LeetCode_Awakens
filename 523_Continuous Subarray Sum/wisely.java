class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k<0) k=Math.abs(k);
        int sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if (k!=0) sum=sum%k;
            if (k==0&&sum!=0) return false;
            if (sum==0 && i>0) return true;
            int res = k-sum;
            if (map.containsKey(res)) {
                return true;
            }
            map.put(res, i);
        }
        return false;
    }
    
    //O(n^2)
    public boolean checkSubarraySum2(int[] nums, int k) {
        if (k<0) k=Math.abs(k);
        long[] sums=new long[nums.length];
        long sum=0;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            sums[i] = sum;
            if (i<1) continue;
            if (k==0) return sum==0;
            for (int j=i-2;j>=-1; j--) {
                long temp = sum-(j==-1?0:sums[j]);
                if (temp%k==0) return true;
            }
        }
        return false;
    }
}