//Leetcode solution
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        for (int i = 1 ;i<prices.length; i++) {
            prices[i-1] = prices[i] - prices[i-1];
        }
        int maxPro = 0;
        for (int i=0;i<prices.length-1; i++) {
            if (prices[i] > 0) maxPro += prices[i];
        }
        return maxPro;
    }
}
