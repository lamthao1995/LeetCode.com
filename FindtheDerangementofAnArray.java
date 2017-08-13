public class Solution {
    public int findDerangement(int n) {
        if(n == 0) return 1;
        if(n == 1) return 0;
        long M = 1000000007;
        long a = 1, b = 0;
        long c = 1;
        for(int i = 2; i <= n; i++){
            c = (i - 1L) * (a + b) % M;
            a = b;
            b = c;
        }
        return (int)c;
    }
    //  public int findDerangement(int n) {
    //     if (n == 0)
    //         return 1;
    //     if (n == 1)
    //         return 0;
    //     int[] dp = new int[n + 1];
    //     dp[0] = 1;
    //     dp[1] = 0;
    //     for (int i = 2; i <= n; i++)
    //         dp[i] = (int)(((i - 1L) * (dp[i - 1] + dp[i - 2])) % 1000000007);
    //     return dp[n];
    // }
}