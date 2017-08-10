public class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min_index = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[min_index] > max){
                max = prices[i] - prices[min_index];
            }
            if(prices[i] < prices[min_index])
                min_index = i;
        }
        if(max >= 0) return max;
        return 0;
    }
}