public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check row
        for(int i = 0; i < 9; i++){
            if(checkRow(board, i) == false) return false;
        }
        for(int i = 0; i < 9; i++){
            if(checkCol(board, i) == false) return false;
        }
        for(int i = 0; i < 9; i = i + 3){
            for(int j = 0; j < 9; j = j + 3){
                if(checkBox(i, j, board) == false) return false;
            }
        }
        return true;
    }
    public boolean checkBox(int startRow, int startCol, char[][] board){
        HashSet<Character> s = new HashSet();
        for(int i = startRow; i < 3 + startRow; i++){
            for(int j = startCol; j < 3 + startCol; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(s.contains(c)){
                        return false;
                    }else{
                        s.add(c);
                    }
                }
            }
        }
        return true;
    }
    public boolean checkRow(char[][] board, int row){
        HashSet<Character> s =new HashSet();
        for(int i = 0; i < 9; i++){
            char c = board[row][i];
            if(c != '.'){
                if(s.contains(c)){
                    return false;
                }else{
                    s.add(c);
                }
            }
        }
        return true;
    }
    public boolean checkCol(char[][] board, int col){
        HashSet<Character> s =new HashSet();
        for(int i = 0; i < 9; i++){
            char c = board[i][col];
            if(c != '.'){
                if(s.contains(c)){
                    return false;
                }else{
                    s.add(c);
                }
            }
        }
        return true;
    }
}