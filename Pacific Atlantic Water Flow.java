public class Solution {
    public static int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> rs = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return rs;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            dfs(pacific, matrix, i, 0, Integer.MIN_VALUE);
            dfs(atlantic, matrix, i, cols - 1, Integer.MIN_VALUE);
        }
        for(int i = 0; i < cols; i++){
            dfs(pacific, matrix, 0, i, Integer.MIN_VALUE);
            dfs(atlantic, matrix, rows - 1, i, Integer.MIN_VALUE);
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j])
                    rs.add(new int[]{i, j});
            }
        }
        return rs;
        
    }
    public static void dfs(boolean[][] visited, int[][] matrix, int row, int col, int parent){
        if(row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0)
            return;
        if(visited[row][col])
            return;
        if(matrix[row][col] < parent)
            return;
        visited[row][col] = true;
        for(int[] move : moves)
            dfs(visited, matrix, row + move[0], col + move[1], matrix[row][col]);
    }
}