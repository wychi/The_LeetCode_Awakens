//Time:O(NlogK)
    //Space:O(1)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priQueue = new PriorityQueue<>();
        for (int i = 0 ; i<nums.length; i++) {
            priQueue.offer(nums[i]);
            if (priQueue.size() > k) {
                priQueue.remove();
            }
        }
        return priQueue.peek();
    }

/**
 * Time :O(NlogN)
 * Space:O(1)
 */
public class Solution {
  public int findKthLargest(int[] nums, int k) {
	final int len = null != nums ? nums.length : 0;
	if (len <= 0) {
	  return -1;
	}
	//Dual-Pivot Quicksort
	//Time: O(NlogN)
	Arrays.sort(nums);
	return nums[len-k];
  }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Method 1:
        // Arrays.sort(nums);//Nlog(N)

        //Method 2: quickSort
        //Time:O(N)
        //Space:O(1)
        shuffle(nums);
        int lo = 0, hi = nums.length-1;
        int targetIdx = nums.length-k;
        while (true) {
            int partitionIdx = quickSort(nums, lo, hi);
            if (partitionIdx > targetIdx) {
                hi = partitionIdx-1;
            } else if (partitionIdx < targetIdx) {
                lo = partitionIdx+1;
            } else {
                break;
            }
        }

        return nums[targetIdx];
    }
    private int quickSort(int[] nums, int lo, int hi) {
        int pivotIdx = lo;
        int pivotValue = nums[pivotIdx];
        lo++;
        while (lo <= hi) {
            if (nums[lo] < pivotValue) {
                lo++;
            } else if (nums[hi] >= pivotValue) {
                hi--;
            } else {
                swap(nums, lo, hi);
            }
        }
        swap(nums, pivotIdx, hi);
        return hi;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0 ; i<nums.length; i++) {
            swap(nums, i, random.nextInt(nums.length));
        }
    }
}
