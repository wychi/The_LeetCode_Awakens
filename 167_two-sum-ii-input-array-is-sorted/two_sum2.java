class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0; int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {i + 1, j + 1};
    }
    /*public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            result[0] = i + 1;
            int value = findValue(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (value != -1) {
                result[1] = value + 1;
                return result;
            }
        }
        return result;
    }
    
    private int findValue(int[] numbers, int start, int end, int target) {
        if (start < 0 || end >= numbers.length || start > end || target < numbers[start] || target > numbers[end]) {
            return -1;
        }
        if (numbers[start] == target) {
            return start;
        }
        if (numbers[end] == target) {
            return end;
        }
        int middle = (start + end) / 2;
        if (numbers[middle] == target) {
            return middle;
        }
        if (start == middle) {
            return -1;
        }
        if (numbers[middle] > target) {
            return findValue(numbers, start, middle - 1, target);
        } else {
            return findValue(numbers, middle + 1, end, target);
        }
    }*/
}