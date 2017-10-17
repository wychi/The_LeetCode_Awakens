class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return nums.length;
        }

        int length[] = new int[nums.length];
        int maxLength = 1;

        int count[] = new int[nums.length];
        int maxCount = 0;

        for (int i = 0; i < nums.length; ++i) {
            count[i] = 1;
            length[i] = 1;

            int max = 0;

            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    int newLength = length[j] + 1;
                    if (newLength > length[i]) {
                        length[i] = newLength;
                        count[i] = count[j];

                    } else if (length[i] == newLength) {
                        count[i] += count[j];
                    }
                }
            }

            if (length[i] > maxLength) {
                maxLength = length[i];
                maxCount = count[i];

            } else if (length[i] == maxLength) {
                maxCount += count[i];
            }
        }
        return maxCount;
    }
}
