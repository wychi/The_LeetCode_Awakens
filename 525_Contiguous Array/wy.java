class Solution {
    // [0,1,1,0,1,1,1,0] 4
    // [0,1,1,0,1,0,1,1] 6
    // [0,0,1,0,0,0,1,1] 6
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            
            if(map.containsKey(sum)) {
                int idx = map.get(sum);
                max = Math.max(max, i - idx);
            } else {
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
