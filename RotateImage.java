public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int n = len;
        for(int i = 0; i < len / 2; i++){
            for(int j = 0; j < Math.ceil(n * 1.0 / 2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }        
    }
}