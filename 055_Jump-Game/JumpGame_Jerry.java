class Solution {
    //TODO improve, O(N)?
    public boolean canJump(int[] nums) {
        int index = 0;
        while(index < nums.length-1 && nums[index] != 0 ) {
            if (index+nums[index] >= nums.length-1) {
                return true;
            }
            
            int next = findMaxIndex(index, index+nums[index], nums);
            if (index == next) {
                index += nums[next];
            } else {
                index = next;
            }
        }
        
        return (index >= nums.length-1) ? true: false;
    }
    
    private int findMaxIndex(int start, int end, int[] nums) {
        int index = start;
        for (int i = start; i<=end; i++) {
            if ((nums[i] + i)> (nums[index] + index)) {
                index = i;
            }
        }
        return index;
    }
}