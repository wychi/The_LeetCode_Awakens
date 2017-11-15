class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(k != 0) {
                if(sum % k == 0 && i > 0)
                    return true;
                
                if(map.containsKey(sum% k))
                    return true;
                
                map.put(sum% k, i);

            } else {
                if(sum == 0 && i >= 1)
                    return true;
            }
            
        }
        
        return false;
    }
}
