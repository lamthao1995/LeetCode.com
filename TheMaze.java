public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] moves = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            if(pos[0] == destination[0] && pos[1] == destination[1])
                return true;
            for(int[] move : moves){
                int x = move[0] + pos[0];
                int y = move[1] + pos[1];
                while(x >= 0 && x < row && y >= 0 && y < col && maze[x][y] != 1){
                    x += move[0];
                    y += move[1];
                }
                if(!visited[x - move[0]][y - move[1]]){
                    queue.add(new int[]{x - move[0], y - move[1]});
                    visited[x - move[0]][y -move[1]] = true;
                }
                
            }
        }
        return false;
    }
}