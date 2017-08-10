public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
         Arrays.sort(coins);
        int[] trace = new int[amount + 1];
        int MAX = Integer.MAX_VALUE;
        for(int i = 1; i <= amount; i++){
            int count = MAX;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && trace[i - coins[j]] <= count){
                    count = trace[i - coins[j]];
                }
            }
            if(count != MAX){
                trace[i] = count + 1;
            }else{
                trace[i] = MAX;
            }
          //  System.out.println(count);
        }
        if(trace[amount] == MAX){
            return -1;
        }else{
            return trace[amount];
        }
    }
}