public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rs = new ArrayList<>();
        if(buildings == null || buildings.length ==0
          || buildings[0].length == 0)
            return rs;
        List<Edge> edges = new ArrayList<>();
        for(int[] b : buildings){
            Edge startEdge = new Edge(b[0], b[2], true);
            edges.add(startEdge);
            Edge end = new Edge(b[1], b[2], false);
            edges.add(end);
        }
        Collections.sort(edges);
        PriorityQueue<Integer> heightMap  = new PriorityQueue<>(10, 
                                                                Collections.reverseOrder());
        for(Edge edge : edges){
            if(edge.isStart){
                if(heightMap.isEmpty() || edge.height > heightMap.peek()){
                    rs.add(new int[]{edge.x, edge.height});
                }
                heightMap.add(edge.height);
                
            }else{
                heightMap.remove(edge.height);
                if(heightMap.isEmpty()){
                    rs.add(new int[]{edge.x, 0});
                }else if(edge.height > heightMap.peek()){
                    rs.add(new int[]{edge.x, heightMap.peek()});
                }
            }
        }
        return rs;
    }
    
    
    class Edge implements Comparable<Edge>{
        int x;
        int height;
        boolean isStart;
        public Edge(int x, int height, boolean isStart){
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
        public int compareTo(Edge ed){
            if(this.x != ed.x)
                return Integer.compare(this.x, ed.x);
            if(this.isStart && ed.isStart)
                return Integer.compare(ed.height, this.height);
            if(!this.isStart && !ed.isStart)
                return Integer.compare(this.height, ed.height);
            return this.isStart ? -1 : 1;
        }
    }
}