class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i:nums) {
            if(i!=0) {
                int j = i;
                while(j!=0) {                 
                    int tmp = nums[j-1];
                    nums[j-1] = 0;
                    j = tmp;
                }
            }
        } 
        
        for(int i= 0;i<nums.length; i++) {
            if(nums[i]!=0) {
                result.add(i+1);
            }
        }
        return result;
    }
}