public class Solution {
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        int[] trace = new int[max + 1];
        for(int i = 1; i <= max; i++)
            trace[i] = i * i;
        for(int i = 0; i <= max; i++){
            if(search(0, max, trace, c - trace[i])){
                return true;
            }
        }
        return false;
    }
    public boolean search(int L, int H, int[] trace, int target){
        if(L > H) return false;
        int mid = (L + H) >> 1;
        if(trace[mid] == target){
            return true;
        }else if(trace[mid] > target){
            return search(L, mid - 1, trace, target);
        }else{
            return search(mid + 1, H, trace, target);
        }
    }
}