class Solution {
    public int majorityElement(int[] nums) {
        int count = 1; int start = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (count==0) {
                count++;
                start=nums[i];
            } else if (start==nums[i]) {
                count++;
            } else{
                count--;
            }
        }
        return start;
    }
    
    /*public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int c = map.containsKey(num) ? map.get(num) : 0;
            c++;
            if (c > nums.length/2) return num;
            map.put(num, c);
        }
        return -1;
    }*/
}