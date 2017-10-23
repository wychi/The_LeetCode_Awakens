class Solution {
    public void wiggleSort(int[] nums) {
        int tmp[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int i = 0, l = (nums.length + 1) / 2, h = nums.length;
        for (int k = 0; k < nums.length; ++k) {
            if (k % 2 == 0) {
                nums[k] = tmp[--l];
            } else {
                nums[k] = tmp[--h];
            }
        }
    }

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return;
        }

        int mid = (nums.length) / 2;
        int mIdx = findKthElement(nums, mid);

        int bottom = 0, top = nums.length - 1;
        int current = 0;
        while (current <= top) {
            if (nums[A(current, n)] < nums[mIdx]) {
                swap(nums, A(current, n), A(top, n));
                top--;

            } else if (nums[A(current, n)] > nums[mIdx]) {
                swap(nums, A(current, n), A(bottom, n));
                bottom++;
                current++;

            } else {
                current += 1;
            }
        }
    }

    private int A(int idx, int n) {
        return (1 + 2 * idx) % (n | 1);
    }

    private int findKthElement(int[] nums, int k) {
        return findKthElement(nums, 0, nums.length - 1, k);
    }

    private int findKthElement(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int pIdx = start;
        for (int i = start; i < end; ++i) {
            if (nums[i] >= pivot) {
                swap(nums, pIdx++, i);
            }
        }
        swap(nums, pIdx, end);

        int m = pIdx - start + 1;
        if (m == k) {
            return pIdx;
        } else if (m < k) {
            return findKthElement(nums, pIdx + 1, end, k - m);
        } else {
            return findKthElement(nums, start, pIdx - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
