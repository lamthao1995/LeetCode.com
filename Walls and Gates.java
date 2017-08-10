public class Solution {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int EMPTY = Integer.MAX_VALUE;
    static int WALL = -1;
    static int GATE = 0;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int rows = rooms.length, cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(rooms[i][j] == GATE)
                    queue.offer(new int[]{i, j});
            }
        }
        while(queue.isEmpty() == false){
            int[] cor = queue.poll();
            for(int[] move : moves){
                int x = cor[0] + move[0];
                int y = cor[1] + move[1];
                if(x >= 0 && y >= 0 && x < rows && y < cols && rooms[x][y] == EMPTY){
                    rooms[x][y] = rooms[cor[0]][cor[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
    
    
}