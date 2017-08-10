public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]){
                max += (prices[i] - prices[i - 1]);
            }
        }
        return max;
    }
}