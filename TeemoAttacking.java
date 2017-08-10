public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int len = timeSeries.length;
        int max = Integer.MAX_VALUE;
        int trace[][] = new int[len][2];
        for(int i = 0; i < len; i++){
            trace[i][0] = timeSeries[i];
            trace[i][1] = trace[i][0] + duration;
        }
        for(int i = 0; i < len - 1; i++){
            if(trace[i][1] >= trace[i + 1][0]){
                trace[i + 1][1] = max(trace[i + 1][1], trace[i][1]);
                trace[i + 1][0] = trace[i][0];
                trace[i][0] = max;
            }
        }
        int counter = 0;
        for(int i = 0; i < len; i++){
            if(trace[i][0] != max){
                counter += trace[i][1] - trace[i][0];
            }
        }
        return counter;
    }
    public int max(int a, int b){
        return a > b ? a : b;
    }
}