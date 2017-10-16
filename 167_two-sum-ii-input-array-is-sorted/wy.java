class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j = numbers.length-1;
        
        int sum = numbers[i] + numbers[j];
        while( sum != target) {
            if(sum > target) {
                j--;
            } else {
                i++;
            }
            sum = numbers[i] + numbers[j];
        }
        
        return new int[] {i+1, j+1};
    }
}
