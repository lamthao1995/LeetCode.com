public class Solution {
    boolean stop = false;
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) return false;
        int cols = matrix[0].length;
        int totalL = rows * cols;
        binaryS(matrix, 0, totalL - 1, target);
        return stop;
    }
    public void binaryS(int[][] matrix, int L, int H, int target){
        if(L > H) return;
        if(stop) return;
        int mid = (L + H) / 2;
        int[] d = getCor(mid, matrix[0].length);
        int midV = matrix[d[0]][d[1]];
        if(midV == target){
            stop = true;
        }else if(midV < target){
            binaryS(matrix, mid + 1, H, target);
        }else{
            binaryS(matrix, L, mid - 1, target);
        }
    }
    public int[] getCor(int index, int cols){
        int[] d = new int[2];
        d[0] = index / cols;
        d[1] = index - d[0] * cols;
        return d;
    }
}