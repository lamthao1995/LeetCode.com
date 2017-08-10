public class Solution {
    int[][] trace;
    int m, n;
    int total = 0;
    public int uniquePaths(int m, int n) {
       trace = new int[m + 1][n + 1];
       for(int i = 1; i <= n; i++){
           trace[m][i] = 1;
       }
       for(int i = 1; i <= m; i++){
           trace[i][n] = 1;
       }
       for(int i = m - 1; i >= 1; i--){
           for(int j = n - 1; j >= 1; j--){
               trace[i][j] = trace[i + 1][j] + trace[i][j + 1];
           }
       }
       return trace[1][1];
    }
   
}