class Solution {
            
    public int maxSubArrayLen(int[] nums, int k) {
     
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(sum == k) {
                max = i + 1;
            }
            
            if(sumIndexMap.containsKey(sum - k)) {
                max = Math.max(max, i - sumIndexMap.get(sum-k));
            }
            
            if(!sumIndexMap.containsKey(sum)) {
                sumIndexMap.put(sum, i);
            }
            
        }
        
        return max;
        
    }
    
}