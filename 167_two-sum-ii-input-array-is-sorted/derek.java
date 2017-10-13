//Key:
    // Use 2 pointer
    //Time:  O(N)
    //Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        final int len = null != numbers ? numbers.length: 0;
        if (len <= 0)
            return new int[2];
        int left = 0, right = len - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                break;
            }
        }
        return new int[]{left+1, right+1};
    }
