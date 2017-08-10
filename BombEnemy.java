public class Solution {
    int rows, cols;
    int max = 0;
    int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //Set<Integer> hash = new HashSet<>();
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return max;
        rows = grid.length;
        cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '0'){
                    dfs(i, j, grid);
                }
            }
        }
        return max;
    }
    public void dfs(int row, int col, char[][] b){
        int count = 0;
        for(int[] move : moves){
            int x = row + move[0];
            int y = col + move[1];
            while(x >=0 && y >= 0 && x < rows && y < cols && b[x][y] != 'W'){
                if(b[x][y] == 'E')
                    count++;
                x += move[0];
                y += move[1];
                //count++;
            }
        }
        max = Math.max(max, count);
    }
}