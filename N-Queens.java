public class Solution {
    int trace[];
    int len;
    List<List<String>> rs = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.len = n;
        trace = new int[n + 1];
        backtrack(1, n);
        return rs;
      
    }
    public void backtrack(int k, int max){
        for(int i = 1; i <= max; i++){
            trace[k] = i;
            if(check(k)){
                if(k == max){
                    //ghi nghiem
                    rootRecord();
                }else if(k < max){
                    backtrack(k + 1, max);
                }
            }
        }
    }
    public void rootRecord(){
        List<String> arr = new ArrayList<>();
        String s = "";
        for(int i = 1; i <= len; i++){
            s = s + ".";
        }
        for(int i = 1; i <= len; i++){
            String temp = s;
            int index = trace[i];
            temp = s.substring(0, index - 1) + "Q" + s.substring(index, len);
                
            arr.add(temp);
        }
        this.rs.add(arr);
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