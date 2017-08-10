public class Solution {
    public int candy(int[] ratings) {
        int numChild = ratings.length;
        int[] trace = new int[numChild];
        Arrays.fill(trace, 1);
        for(int i = 1; i < numChild; i++){
            if(ratings[i] > ratings[i - 1]){
                trace[i] = trace[i - 1] + 1;
            }
        }
        for(int i = numChild - 2; i >= 0; i--){
            if(ratings[i + 1] < ratings[i]){
                trace[i] = Math.max(trace[i], trace[i + 1] + 1);
            }
        }
        int rs = 0;
        for(int x : trace){
            rs += x;
        }
        return rs;
    }
}