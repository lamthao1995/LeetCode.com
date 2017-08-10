public class Solution {
    int[][] trace;
    int rows, cols;
    boolean check = false;
    public boolean exist(char[][] board, String word) {
        int initR = -1, initC = -1;
        rows = board.length; cols = board[0].length;
        trace = new int[rows][cols];
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == word.charAt(0)){
                    initR = i; initC = j;
                    findWord(0, word, initR, initC, board);
                }
            }
        }
        return check;
    }
    public void findWord(int index, String s, int x, int y, char[][] b){
        if(x < 0 || y < 0 || x >= rows || y >= cols){
            return;
        }
        if(trace[x][y] != 0 || check == true) return;
        trace[x][y] = 1;
        
        if(b[x][y] == s.charAt(index)){
            if(index == s.length() - 1){
                check = true;
            }else if(index < s.length() - 1){
                findWord(index + 1, s, x + 1, y, b);
                findWord(index + 1, s, x - 1, y, b);
                findWord(index + 1, s, x, y + 1, b);
                findWord(index + 1, s, x, y - 1, b);
            }
        }
        
        trace[x][y] = 0;
    }
}