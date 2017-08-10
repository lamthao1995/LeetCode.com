public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Subset[] set = new Subset[n];
        for(int i = 0; i < n; i++)
            set[i] = new Subset(i);
        if(edges.length < n - 1)
            return false;
        for(int[] d : edges){
         //   union(d[0], d[1], set);
            int x = find(d[0], set);
            int y = find(d[1], set);
            if(x != y){
                union(x, y, set);
            }else
                return false;
        } 
        return true;
    }
    public static int find(int x, Subset[] set){
        if(set[x].parent != x){
            set[x].parent = find(set[x].parent, set);
        }
        return set[x].parent;
    }
    public static void union(int x, int y, Subset[] set){
        int xroot = find(x, set);
        int yroot = find(y, set);
        if(set[xroot].rank < set[yroot].rank){
            set[xroot].parent = yroot;
        }else if(set[xroot].rank > set[yroot].rank){
            set[yroot].parent = xroot;
        }else{
            set[yroot].parent = xroot;
            set[xroot].rank++;
        }
    }
    public static class Subset{
        int rank;
        int parent;
        public Subset(int parent){
            this.parent = parent;
            rank = -1;
        }
    }
}