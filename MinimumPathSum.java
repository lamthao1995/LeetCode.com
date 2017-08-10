public class Solution {
    int trace[][];
    int rows, cols;
    public int minPathSum(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        trace = new int[this.rows][this.cols];
        trace[0][0] = grid[0][0];
        for(int i = 1; i < this.rows; i++){
            trace[i][0] = trace[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < this.cols; i++){
            trace[0][i] = trace[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < this.rows; i++){
            for(int j = 1; j < this.cols; j++){
                trace[i][j] = Math.min(trace[i - 1][j], trace[i][j - 1]) + grid[i][j];
            }
        }
        return trace[this.rows - 1][this.cols - 1];
    }
}