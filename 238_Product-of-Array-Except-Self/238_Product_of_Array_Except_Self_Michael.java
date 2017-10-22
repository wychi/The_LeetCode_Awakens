class Solution {
    public int[] productExceptSelf(int[] nums) {
        // build table
        int [] lTable = buildLeftTable(nums);
        int [] rTable = buildRightTable(nums);
                
        // compute 
        int [] output = new int[nums.length];
        output[0] = rTable[1];
        output[nums.length-1] = lTable[nums.length-2];
        for (int i=1;i<nums.length - 1;i++) {
            output[i]=lTable[i-1] * rTable[i+1];
        }
        return output;
    }
    
    public int [] buildLeftTable(int [] nums) {
        int [] iTable = new int[nums.length];
        iTable[0] = nums[0];
        for (int i=1;i<=nums.length - 1;i++) {
            iTable[i] = iTable[i-1] * nums[i];
        }
        return iTable;
    }
    
    public int [] buildRightTable(int [] nums) {
        int [] iTable = new int[nums.length];
        iTable[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length - 2;i>=0;i--) {
            iTable[i] = iTable[i+1] * nums[i];
        }
        return iTable;
    }
}