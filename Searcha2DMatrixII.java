public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        if(rows == 0) return false;
        int cols = matrix[0].length;
        while(start < rows && start < cols){
            boolean check = binaryV(start, rows - 1, matrix, start, target)
                        || binaryH(start, cols - 1, matrix, start, target);
            if(check == true) return true;
            start++;
        }
        return false;
    }
   
    public boolean binaryV(int L, int H, int[][] matrix, int col, int target){
        if(L > H) return false;
        int mid = (L + H) / 2;
        if(matrix[mid][col] == target) return true;
        else if(matrix[mid][col] > target){
            return binaryV(L, mid - 1, matrix, col, target);
        }else{
            return binaryV(mid + 1, H, matrix, col, target);
        }
    }
    public boolean binaryH(int L, int H, int[][] matrix, int row, int target){
        if(L > H) return false;
        int mid = (L + H) / 2;
        if(matrix[row][mid] == target) return true;
        else if(matrix[row][mid] > target){
            return binaryH(L, mid - 1, matrix, row, target);
        }else{
            return binaryH(mid + 1, H, matrix, row, target);
        }
    }
}