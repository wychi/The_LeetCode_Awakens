class Solution {
    
    public int findMaxLength(int[] nums) {

       int diff = 0;
       int maxLen = 0; 
       HashMap<Integer, Integer> diffMap = new HashMap<>();
       diffMap.put(0, -1);
        
       for(int i=0;i<nums.length;i++) {
           
           if(nums[i]>0) {
               diff++;
           } else {
               diff--;
           }
                      
           if(diffMap.containsKey(diff)) {
               maxLen = Math.max(maxLen, i-diffMap.get(diff));
           } else {
               diffMap.put(diff, i);
           }
                                 
       }
        
       return maxLen;
        
    }
}
