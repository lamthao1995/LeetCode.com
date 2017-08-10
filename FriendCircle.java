

public class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0)
            return 0;
        int len = M.length;
        int count = 0;
        Subset[] set = new Subset[len];
        for(int i = 0; i < len; i++)
            set[i] = new Subset(i);
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(M[i][j] != 0){
                    int x = find(i, set);
                    int y = find(j, set);
                    if(x != y){
                        count++;
                        union(x, y, set);
                    }
                }
            }
        }
        return len - count;
        
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
        if(set[xroot].parent > set[yroot].parent){
            set[yroot].parent = xroot;
        }else if(set[xroot].parent < set[yroot].parent){
            set[xroot].parent = yroot;
        }else{
            set[yroot].parent = xroot;
            set[xroot].rank++;
        }
    }
    public class Subset{
        int rank = 0;
        int parent;
        public Subset(int p){
            parent = p;
        }
    }
    
}
