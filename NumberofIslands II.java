public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] xMove = {0,0,1,-1};
        int[] yMove = {1,-1,0,0};
        Subset[] set = new Subset[m * n];
        for(int i = 0; i < set.length; i++)
            set[i] = new Subset(-1);
        List<Integer> rs = new ArrayList<>();
        for(int[] tuple : positions){
            set[tuple[0] * n + tuple[1]].parent = tuple[0] * n + tuple[1];
           int count = rs.isEmpty() ? 1 : rs.get(rs.size() - 1) + 1;
           for(int i = 0; i < 4; i++){
               int newX = xMove[i] + tuple[0];
               int newY = yMove[i] + tuple[1];
               if(newX < 0 || newY < 0 || newX >= m || newY >= n || set[newX * n + newY].parent == -1)
                   continue;
               int r1 = find(tuple[0] * n + tuple[1], set);
               int r2 = find(newX * n + newY, set);
               if(r1 != r2){
                   count--;
                   union(r1, r2, set);
               }
           }
            rs.add(count);
        }
        return rs;
    }
    public int find(int x, Subset[] set){
        if(set[x].parent != x){
            set[x].parent = find(set[x].parent, set);
        }
        return set[x].parent;
    }
    public void union(int x, int y, Subset[] set){
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
        int rank = -1;
        int parent;
        public Subset(int p){
            this.parent = p;
        }
    }
}