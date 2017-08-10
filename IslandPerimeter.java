public class Solution {
    int total = 0;
    int rows = 0, cols = 0;
    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1) calculate(i, j, grid);
            }
        }
        return total;
    }
    public void calculate(int row, int col, int[][] grid){
       int max = 4;
       if(col > 0 && grid[row][col - 1] == 1) max--;
       if(col < this.cols - 1 && grid[row][col + 1] == 1) max--;
       if(row > 0 && grid[row - 1][col] == 1) max--;
       if(row < this.rows - 1 && grid[row + 1][col] == 1) max--;
       this.total += max;
    }
}