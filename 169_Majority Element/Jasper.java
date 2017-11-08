class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int i:nums) {
            
            int freq = freqMap.getOrDefault(i,0);
            freq++;
            if(freq > nums.length / 2) {
                return i;
            }
            freqMap.put(i, freq);            
        }
        return -1;
    }
}