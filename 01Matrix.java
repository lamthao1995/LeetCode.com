public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int trace[][] = new int[matrix.length][matrix[0].length];
        for(int[] r : trace)
            Arrays.fill(r, Integer.MAX_VALUE - 10);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    trace[i][j] = 0;
                }else{
                    if(j > 0)
                        trace[i][j] = Math.min(trace[i][j], trace[i][j - 1] + 1);
                    if(i > 0)
                        trace[i][j] = Math.min(trace[i][j], trace[i - 1][j] + 1);
                }
            }
        }
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(matrix[i][j] == 1){
                    if(i < matrix.length - 1){
                        trace[i][j] = Math.min(trace[i][j], trace[i + 1][j] + 1);
                    }
                    if(j < matrix[0].length - 1){
                        trace[i][j] = Math.min(trace[i][j], trace[i][j + 1] + 1);
                    }
                }
            }
        }
       
        return trace;
    }
}