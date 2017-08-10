public class Solution {
    public int minDistance(String word1, String word2) {
        int lenW1 = word1.length();
        int lenW2 = word2.length();
        int[][] dp = new int[lenW1 + 1][lenW2 + 1];
        for(int i = 1; i <= lenW1; i++){
            for(int j = 1; j <= lenW2; j++){
                 if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return lenW1 + lenW2 - 2*dp[lenW1][lenW2];
    }
}