class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 0)
            return 0;
        int maxProfit = 0;
        int maxCurr = 0;
        for (int i = 1 ; i<prices.length; i++) {
            maxCurr = Math.max(0, maxCurr += prices[i]-prices[i-1]);
            maxProfit = Math.max(maxProfit, maxCurr);
        }
        return maxProfit;
    }
}


//Find min Value
//Time:O(N)
//Space:O(1)
class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length<=0)
            return 0;
        int minValue = prices[0];
        int maxProfit = 0;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] > minValue) {
                maxProfit = Math.max(maxProfit, prices[i] - minValue);
            } else {
                minValue = prices[i];
            }
        }
        return maxProfit;
    }
}
