class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length - 1;
        while (l < h) {
            int n = (numbers[l] + numbers[h]);
            if (n < target) {
                l++;
            } else if (n > target) {
                h--;
            } else {
                break;
            }
        }
        return new int[]{l+1, h+1};
    }
}
