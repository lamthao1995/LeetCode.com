public class Solution {
    int trace[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        trace = new int[m][n];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) break;
            trace[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
             if(obstacleGrid[0][i] == 1) break;
            trace[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0 ){
                    trace[i][j] = trace[i - 1][j] + trace[i][j - 1];
                }
            }
        }
        return trace[m - 1][n - 1];
        
    }
}