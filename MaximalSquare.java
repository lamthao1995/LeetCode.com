public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int lengthOfEdge = Integer.MIN_VALUE;
        int cols = matrix[0].length;
        int[][] trace = new int[rows + 1][cols + 1];
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    trace[i][j] = min(trace[i - 1][j], trace[i][j - 1], trace[i - 1][j - 1]) + 1;
                    lengthOfEdge = Math.max(lengthOfEdge, trace[i][j]);
                }
            }
        }
        return lengthOfEdge * lengthOfEdge;
    }
    public int min(int a, int b, int c){
        int min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        return min;
    }
}