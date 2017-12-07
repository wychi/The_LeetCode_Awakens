class Solution {
    public int[] maxSumOfThreeSubarrays1(int[] nums, int K) {
        //W is an array of sums of windows
        int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) sum -= nums[i-K];
            if (i >= K-1) W[i-K+1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for (int j = K; j < W.length - K; j++) {
            int i = left[j - K], k = right[j + K];
            if (ans[0] == -1 || W[i] + W[j] + W[k] >
                    W[ans[0]] + W[ans[1]] + W[ans[2]]) {

                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] W = new int[nums.length - (k - 1)];
        int[] L = new int[W.length];
        int[] R = new int[W.length];
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i-k];
            if (i >= k-1) W[i-k+1] = sum;
        }
        
        L[0] = 0;
        R[R.length - 1] = R.length - 1;
        for(int i=1; i<L.length; i++) {
            int j = L.length - 1 - i;
            L[i] = W[i] > W[L[i-1]] ? i : L[i-1];
            R[j] = W[j] > W[R[j+1]] ? j : R[j+1];
        }
        
        // dump(W);
        // dump(L);
        // dump(R);
        int[] result = new int[3];
        int maxVal = Integer.MIN_VALUE;
        for(int j=k;j<W.length-k; j++) {
            int val = W[j] + W[L[j-k]] + W[R[j+k]];
            if( val > maxVal ) {
                result[0] = L[j-k];
                result[1] = j;
                result[2] = R[j+k];
                maxVal = val;
            }
        }
        
        return result;
    }
    void dump(int[] array) {
        String msg = "";
        for(int x : array) {
            msg += x + ", ";
        }
        System.out.println(msg);
    }
}
