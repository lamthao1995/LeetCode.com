public class Solution {
    public int numSquares(int n) {
        int max = (int)Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= max; j++){
                int square = j * j;
                if(i == square){
                    dp[i] = 1;
                }else if(i > square){
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
        }
        return dp[n];
    }
    
}