public class Solution {
    int trace[];
    public int countComponents(int n, int[][] edges) {
        trace = new int[n];
        Vertex[] vertices = new Vertex[n];
        for(int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);
        for(int[] d : edges){
            vertices[d[0]].child.add(d[1]);
            vertices[d[1]].child.add(d[0]);
        }
        int count = 0;
        for(Vertex vertex : vertices){
            if(trace[vertex.val] == 0){
                dfs(vertex.val, vertices, trace);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int vertex, Vertex[] v, int[] trace){
        if(trace[vertex] == 1)
            return;
        trace[vertex] = 1;
        for(int child : v[vertex].child){
            dfs(child, v, trace);
        }
    }
    public static class Vertex{
        int val;
        Set<Integer> child = new HashSet();
        public Vertex(int val){
            this.val = val;
        }
    }
}