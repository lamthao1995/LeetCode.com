public class Solution {
    int trace[];
    public int[] countBits(int num) {
        trace = new int[num + 1];
        for(int i = 1; i <= num; i++){
            trace[i] = get(i);
        }
        return trace;
    }
    public int get(int x){
        int counter = 0;
        while(x != 0){
            x = x & (x - 1);
            counter++;
        }
        return counter;
    }
}