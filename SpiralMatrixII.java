public class Solution {
    int[][] ring;
    public int[][] generateMatrix(int n) {
        if(n == 0){
            ring = new int[0][0];
            return ring;
        }
        ring = new int[n][n];
        ring[0][0] = 1;
        int row_start = 0, col_start = 0;
        int start = 1;
        while(row_start * 2 < n && col_start < 2 * n){
            fillRing(row_start, col_start, n);
            row_start++;
            col_start++;
        }
        print(n);
        return ring;
        
    }
    public void fillRing(int row, int col, int n){ ///  1 2 3 4
        int start = 0;
        if(col != 0){
            start = ring[row][col - 1];
            System.out.println("start " + start);
        }
        for(int i = row; i < n - row; i++){//          12 13145    
            ring[row][i] = start + 1;
            start++;
        }///                                           10 9 8 7
        for(int i = row + 1; i < n - row; i++){
            ring[i][n - col - 1] = ring[i - 1][n - col - 1] + 1;
        }
        for(int i = n - col - 2; i >= col; i--){
            ring[n - row - 1][i] = ring[n - row - 1][i + 1] + 1;
        }
        for(int i = n - row - 2; i > row; i--){
            ring[i][col] = ring[i + 1][col] + 1;
        }
    }
    public void print(int n){
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(ring[i]));
        }
    }
}