class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;
        return quickSelect(nums, left, right, k); // space: O(1), time: O(N)
    }
    
    private int quickSelect(int[] nums, int left, int right, int k){
        // select pivot randomly
        Random random = new Random();
        int pivotIndex = random.nextInt(right-left+1)+left;
        int pivot = nums[pivotIndex];
        
        // move pivot to end
        swap(nums, pivotIndex, right);
        
        int pointIndex = left;
        for (int i=left; i<=right-1; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, pointIndex++);
            }
        }
        
        // move back
        swap(nums, pointIndex, right);
        
        int count = pointIndex-left+1;
        if (k == count) {
            return nums[pointIndex];
        } else if (k > count) { //right
            return quickSelect(nums, pointIndex+1, right, k-count);
        } else { //left
            return quickSelect(nums, left, pointIndex-1, k);
        }
    }
    
    private void swap(int[] target, int index1, int index2) {
        int temp = target[index1];
        target[index1] = target[index2];
        target[index2] = temp;
    }
    
    public int findKthLargest_old(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // space: O(k)
        for (int n: nums) { //time: O(NlogK)
            queue.offer(n);  
            
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
        return queue.peek();
    }
}