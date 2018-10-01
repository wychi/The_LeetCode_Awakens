class Solution {
    //Method 1: sorting
    //Time:O(NlogN) //from sort algorithm
    //Space:O(1)
    // public int missingNumber(int[] nums) {
    //     if (nums.length == 1) {
    //         return nums[0] != 0 ? 0 : 1;
    //     }
    //     Arrays.sort(nums);
    //     if (nums[0] != 0) return 0;
    //     int i = 0;
    //     for (i = 0; i<nums.length-1;i++) {
    //         if (nums[i+1]- nums[i] > 1) {
    //             break;
    //         }
    //     }
    //     return i+1;
    // }
    
    //Method 2: hashSet
    //Time:O(N)
    //Space:O(N)
    // public int missingNumber(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int i: nums) {
    //         set.add(i);
    //     }
    //     int i = 0;
    //     while (i < nums.length) {
    //         if (!set.contains(i)) return i;
    //         i++;
    //     }
    //     return i;
    // }
    
    //Method 3: xor
    //Time:O(N)
    //Space:O(1)
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0 ; i<nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }
    
    //Method 4: n(n+1) / 2
    //Time:O(N)
    //Space:O(1)
    // public int missingNumber(int[] nums) {
    //     int sum = nums.length * (nums.length+1) / 2;
    //     for (int i :nums) {
    //         sum-=i;
    //     }
    //     return sum;
    // }
}
