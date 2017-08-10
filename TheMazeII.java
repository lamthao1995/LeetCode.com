public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] dis = new int[row][col];
       
        for(int[] r : dis)
            Arrays.fill(r, Integer.MAX_VALUE);
        dis[start[0]][start[1]] = 0;
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int[] move : moves){
                int cost = 0;
                int x = pos[0] + move[0];
                int y = pos[1] + move[1];
                while(x >= 0 && y >= 0 && x < row && y < col && maze[x][y] != 1){
                    x += move[0];
                    y += move[1];
                    cost++;
                }
                if(dis[pos[0]][pos[1]] + cost < dis[x - move[0]][y - move[1]]){
                    queue.add(new int[]{x - move[0], y - move[1]});
                    dis[x - move[0]][y - move[1]] = dis[pos[0]][pos[1]] + cost;
                }
                
            }
        }
        if(dis[destination[0]][destination[1]] == Integer.MAX_VALUE)
            return -1;
        return dis[destination[0]][destination[1]];
    }
}