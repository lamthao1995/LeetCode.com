public class Solution {
    int[] trace;
    int total = 0;
    public int totalNQueens(int n) {
        trace = new int[n + 1];
        backtrack(1, n);
        return this.total;
    }
    public void backtrack(int k, int max){
     for(int i = 1; i <= max; i++){
            trace[k] = i;
            if(check(k)){
                if(k == max){
                   this.total++;
                }else if(k < max){
                    backtrack(k + 1, max);
                }
            }
        }
    }
     public boolean check(int k){
        for(int i = 1; i <= k - 1; i++){
            if(trace[i] == trace[k]){
                return false;
            }
            if(Math.abs(trace[k] - trace[i]) == Math.abs(i - k)){
                return false;
            }
        }
        return true;
    }
}