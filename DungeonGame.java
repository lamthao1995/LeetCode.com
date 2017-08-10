public class Solution {
    int trace[][];
    int rows, cols;
    public int calculateMinimumHP(int[][] dungeon) {
        this.rows = dungeon.length;
        this.cols = dungeon[0].length;
        trace = new int[rows][cols];
        
        trace[rows - 1][cols - 1] = Math.max(1, 1 - dungeon[rows - 1][cols - 1]);
        for(int i = rows - 2; i >= 0; i--){
            trace[i][cols - 1] = Math.max(trace[i + 1][cols - 1] - dungeon[i][cols - 1], 1);
        }
        for(int i = cols - 2; i >= 0; i--){
            trace[rows - 1][i] = Math.max(trace[rows - 1][i + 1] - dungeon[rows - 1][i], 1);
        }
        
        for(int i = rows - 2; i >= 0; i--){
            for(int j = cols - 2; j >=0; j--){
                int down = Math.max(1, trace[i + 1][j] - dungeon[i][j]);
                int right = Math.max(1, trace[i][j + 1] - dungeon[i][j]);
                trace[i][j] = Math.min(right, down);
            }
        }
        return trace[0][0];
        
    }
}