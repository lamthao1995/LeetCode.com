class Solution {
    int rows = 0;
    int cols = 0;
    public int[][] imageSmoother(int[][] M) {
        rows = M.length;
        if(rows == 0)
            return M;
        cols = M[0].length;
        int[][] rs = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                setValue(i, j, M, rs);
            }
        }
        return rs;
    }
    public void setValue(int row, int col, int[][] M, int[][] rs){
        int counter = 0;
        int sum = 0;
        for(int i = (row == 0) ? 0 : row - 1; i <= ((row == rows - 1) ? row : row + 1); i++){
            for(int j = ((col == 0) ? 0 : col - 1); j <= ((col == cols - 1) ? col : col + 1); j++){
                sum += M[i][j];
                counter++;
            }
        }
        rs[row][col] = sum / counter;
    }
}