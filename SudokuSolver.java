public class Solution {
    boolean stop = false;
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }
    public void backTrack(char[][] board){
        if(this.stop == true) return;
        int[] d = emptyCor(board);
        if(d[0] == -1) {
            this.stop = true;
            return;
        }
        for(int i = 1; i <= 9; i++){
            String s = "" + i;
            char val = s.charAt(0);
            //System.out.println(val);
            if(validRow(board, d[0], val) && validCol(board, d[1], val) && validBox(board,d[0] - d[0] % 3,d[1] - d[1] % 3 ,val)){
                board[d[0]][d[1]] = val;
                backTrack(board);
                if(this.stop == false) board[d[0]][d[1]] = '.';
            }
        }
        
    }
    public boolean validBox(char[][] board, int rowStart, int colStart, int value){
        for(int i = rowStart; i < rowStart + 3; i++){
            for(int j = colStart; j < colStart + 3; j++){
                if(board[i][j] == value) return false;
            }
        }
        return true;
    }
    public boolean validRow(char[][] board, int row, char value){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == value){
                return false;
            }
        }
        return true;
    }
    public boolean validCol(char[][] board, int col, char value){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == value){
                return false;
            }
        }
        return true;
    }
    public int[] emptyCor(char[][] b){
        int[] d = new int[2];
        d[1] = -1; d[0] = -1;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(b[i][j] == '.'){
                    d[0] = i; d[1] = j;
                    return d;
                }
            }
        }
        return d;
    }
}