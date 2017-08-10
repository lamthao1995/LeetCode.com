public class Solution {
    int rows, cols;
    public void solve(char[][] board) {
        rows = board.length;
        if(rows == 0) return;
        cols = board[0].length;
    
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                merge(i, 0, board);
            }
        }
         for(int i = 0; i < rows; i++){
            if(board[i][cols - 1] == 'O'){
                merge(i, cols -1, board);
            }
        }
        for(int i = 0; i < cols; i++){
            if(board[0][i] == 'O'){
                merge(0, i, board);
            }
        }
         for(int i = 0; i < cols; i++){
            if(board[rows - 1][i] == 'O'){
                merge(rows - 1, i, board);
            }
        }
    
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void merge(int row, int col, char[][] board){
        int index = row * cols + col;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        board[row][col] = '1';
        
        while(!queue.isEmpty()){
            int top = queue.poll();
            int i = top / cols;
            int j = top % cols;
            
            if(i >= 1 && board[i - 1][j] == 'O'){
                board[i - 1][j] = '1';
                queue.offer((i - 1) * cols + j);
            }
            if(i < rows - 1 && board[i + 1][j] == 'O'){
                board[i + 1][j] = '1';
                queue.offer((i + 1) * cols + j);
            }
            if(j >= 1 && board[i][j - 1] == 'O'){
                board[i][j - 1] = '1';
                queue.offer(i * cols + j - 1);
            }
            if(j < cols - 1 && board[i][j + 1] == 'O'){
                board[i][j + 1] = '1';
                queue.offer(i * cols + j + 1);
            }
        }
    }
    
}