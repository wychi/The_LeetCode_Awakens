class Solution {
    //Method 2:
    // Binary search
    //Time: O(N logN)
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
    
    //Method 3:
    //DP record array store last longest number
    // public int lengthOfLIS(int[] nums) {
    // }
    
    //Method 1:
    //DP record array store length
    //Time: O(N^2)
//     public int lengthOfLIS(int[] nums) {
//         final int len = null != nums ? nums.length: 0;
//         if (len <= 1) return len;
        
//         int[] lenArray = new int[len];
//         for (int i = 0 ; i<len; i++) {
//             lenArray[i] = 1;
//             for (int j = 0; j<i ;j++) {
//                 if (nums[i] > nums[j]) {
//                     if (lenArray[j]+1 > lenArray[i]) {
//                         lenArray[i] = lenArray[j]+1;
//                     }
//                 }
//             }
//         }
//         int max = 0;
//         for (int n: lenArray) {
//             max = Math.max(max, n);
//         }
//         return max;
//     }
}
