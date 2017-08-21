public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //0-1 knapsack problem
        int weight1 = 0, weight2 = 0;
        int[][] dp = new int[m + 1][n + 1];
        for(String s : strs){
            int[] d = count01(s);
            int numZero = d[0];
            int numOne = d[1];
            for(int i = m; i >= numZero; i--){
                for(int j = n; j >= numOne; j--){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - numZero][j - numOne]);
                }
            }
        }
        return dp[m][n];
    }
    public int[] count01(String s){
        int count0 = 0, count1 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                count0++;
            }else{
                count1++;
            }
        }
        return new int[]{count0, count1};
    }
}