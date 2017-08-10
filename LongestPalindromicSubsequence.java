public class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len];
        for(int i = 0; i < len; i++)
            dp[1][i] = 1;
        for(int i = 2; i <= len; i++)
            for(int j = 0; j < len - i + 1; j++)
                dp[i][j] = s.charAt(j) == s.charAt(i + j - 1) ? 2 + dp[i - 2][j + 1] :
                                            Math.max(dp[i - 1][j] , dp[i - 1][j + 1]);
        return dp[len][0];
    }
}
  // int n = s.size();
  //       vector<vector<int>> dp(n+1,vector<int>(n));
  //       for(int i=0;i<n;i++) dp[1][i]=1;
  //       for(int i=2;i<=n;i++) //length
  //           for(int j=0;j<n-i+1;j++) {//start index 
  //               dp[i][j] = s[j]==s[i+j-1]?2+dp[i-2][j+1]:max(dp[i-1][j],dp[i-1][j+1]);
  //       return dp[n][0]; 