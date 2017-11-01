class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            int count = counts[i];
            for (int j = 0; j < count; j++) {
                nums[index] = i; index++;
            }
        }
        /*int index = 0; int p1 = 0; int p2 = nums.length - 1;
        while (index <= p2) {
            if (nums[index] == 0) {
                int temp = nums[index];
                nums[index] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
            if (nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[p2];
                nums[p2] = temp;
                p2--;
                index--;
            }
            index++;
        }*/
    }
}