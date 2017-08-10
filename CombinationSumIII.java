public class Solution {
    int[] trace;
    int sum = 0;
    List<List<Integer>> arr = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        trace = new int[k];
        backtrack(0, k, n);
        return arr;
    }
    public void backtrack(int k, int max, int total){
        int start = 0;
        if(k == 0){
            start = 1;
        }else{
            start = trace[k - 1] + 1;
        }
        for(int i = start; i <= 9; i++){
            trace[k] = i;
            sum += i;
            if(k == max - 2){
              if(total - sum > trace[k] && total - sum <= 9){
                  trace[k + 1] = total - sum;
                  rootRecord();
              }
            }else if(k < max - 2){
                backtrack(k + 1, max, total);
            }
            sum -= i;
        }
    }
    public void rootRecord(){
        List<Integer> rs = new ArrayList<>();
        for(int i = 0; i < this.trace.length; i++){
            rs.add(trace[i]);
        }
        arr.add(rs);
    }
   
}