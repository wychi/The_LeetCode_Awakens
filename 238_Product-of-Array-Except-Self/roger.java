class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; ++i) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        int result[] = left;
        for (int i = n - 1; i >= 0; --i) {
            result[i] = right * left[i];
            right *= nums[i];
        }
        return result;
    }
  
    public int[] productExceptSelf(int[] nums) {
        long product = 1;
        long productWithOutZ = 1;
        int hasZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            product *= nums[i];
            if (nums[i] != 0) {
                productWithOutZ *= nums[i];
            } else {
                hasZero++;
            }
        }

        int result[] = new int[nums.length];

        if (nums.length == 0) {
            return result;
        }

        for (int i = 0; i < result.length; ++i) {
            if (nums[i] == 0) {
                if (hasZero > 1) {
                    result[i] = 0;
                } else {
                    result[i] = (int) productWithOutZ;
                }
            } else {
                if (hasZero > 0) {
                    result[i] = 0;
                } else {
                    result[i] = (int) (product / nums[i]);
                }
            }
        }
        return result;
    }
}
