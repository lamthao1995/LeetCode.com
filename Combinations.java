public class Solution {
    List<List<Integer>> rs = new ArrayList<>();
    int[] trace;
    int k, n;
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        trace = new int[n + 1];
        backtrack(1,0);
        return rs;
    }
     public void backtrack(int v, int num1){
       for(int i = 0; i <= 1; i++){
           trace[v] = i;
           if(trace[v] == 1){
               num1++;
           }
           if(num1 == k){
               //in nghiem
               ArrayList<Integer> temp = new ArrayList<>();
               for(int a = 1; a <= n; a++){
                   if(trace[a] != 0) temp.add(a);
               }
               rs.add(temp);
           }else if(num1 < k){
               if(v < n){
                   backtrack(v + 1, num1);
               }
           }
           trace[v] = 0;
       }
    }
}