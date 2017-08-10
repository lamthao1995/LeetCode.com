public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Edge[] edgesArr = new Edge[n];
        for(int i = 0; i < n; i++){
            edgesArr[i] = new Edge();
        }
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            edgesArr[x].child.add(y);
            edgesArr[y].child.add(x);
        }
        List<Integer> current = new ArrayList<>();
        if(n == 1){
            current.add(0);
            return current;
        }
        for(int i = 0; i < edgesArr.length; i++){
            if(edgesArr[i].child.size() == 1)
                current.add(i);
        }
        ///bfs
        while(true){
            List<Integer> next = new ArrayList<>();
            for(int node : current){
                for(int neighbor : edgesArr[node].child){
                    edgesArr[neighbor].child.remove(Integer.valueOf(node));
                    if(edgesArr[neighbor].child.size() == 1)
                        next.add(neighbor);
                }
            }
            if(next.size() == 0) return current;
            current = next;
        }
    }
    
    class Edge{
        List<Integer> child = new ArrayList<>();
    }
}