public class Solution {
    public final static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public final static String[] ds = new String[]{"u", "r", "d", "l"};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n  = maze[0].length;
        Point[][] points = new Point[m][n];
        for(int i = 0; i < m * n; i++)
            points[i / n][i % n] = new Point(i / n, i % n);
        PriorityQueue<Point> heap = new PriorityQueue<>();
        heap.offer(new Point(ball[0], ball[1], 0, ""));
        while(!heap.isEmpty()){
            Point p = heap.poll();
            if(points[p.x][p.y].compareTo(p) <= 0) continue;
            points[p.x][p.y] = p;
            for(int i = 0; i < 4; i++){
                int xx = p.x, yy = p.y, cost = p.cost;
                while(xx >= 0 && xx < m && yy >=0 && yy < n && maze[xx][yy] == 0
                     && (xx != hole[0] || yy != hole[1])){
                    xx += dir[i][0];
                    yy += dir[i][1];
                    cost++;
                }
                if(xx != hole[0] || yy != hole[1]){
                    xx -= dir[i][0];
                    yy -= dir[i][1];
                    cost--;
                }
                heap.offer(new Point(xx, yy, cost, p.s + ds[i]));
            }
        }
        return points[hole[0]][hole[1]].cost == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].s;
        
    }
    
    
    public static class Point implements Comparable<Point>{
        int x, y , cost;
        String s;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.cost = Integer.MAX_VALUE;
        }
        public Point(int x, int y, int cost, String s){
            this.x = x;
            this.y = y;
            this.s = s;
            this.cost = cost;
        }
        public int compareTo(Point p){
            if(p.cost == this.cost)
                return this.s.compareTo(p.s);
            return this.cost - p.cost;
        }
    }
}