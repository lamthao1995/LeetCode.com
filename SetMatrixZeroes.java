public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRZero = false, firstCZero = false;
        int rows = matrix.length, cols = matrix[0].length;
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                firstCZero = true;
                break;
            }
        }
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                firstRZero = true;
                break;
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRZero){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }
        if(firstCZero){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
    }
}