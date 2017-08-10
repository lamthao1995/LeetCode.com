public class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] mem = new int[matrix.length][matrix[0].length];
        int longest = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                longest = Math.max(longest, dfs(mem, matrix, i, j));
            }
        }
        return longest;
    }
    private int dfs(int[][] mem, int[][] matrix, int row, int col){
        if(mem[row][col] != 0)
            return mem[row][col];
        for(int m = 0; m < 4; m++){
            int x = row + dx[m];
            int y = col + dy[m];
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length 
              && matrix[x][y] > matrix[row][col]){
                mem[row][col] = Math.max(mem[row][col],
                                        dfs(mem, matrix, x, y));
            }
        }
        return ++mem[row][col];
    }
}