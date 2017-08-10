public class Solution {
    int rows, cols;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int total = 0;
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    total++;
                    bfs(i, j, grid);
                }
            }
        }
        return total;
    }
    public void bfs(int row, int col, char[][] grid){
        if(row >= rows || col >= cols || col < 0 || row <0)
            return;
        if(grid[row][col] == '0') return;
        grid[row][col] = '0';
        bfs(row + 1, col, grid);
        bfs(row - 1, col, grid);
        bfs(row, col + 1, grid);
        bfs(row, col - 1, grid);
    }
}