public class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for(int i : machines)
            total += i;
        if(total % machines.length != 0)
            return -1;
        int max = Integer.MIN_VALUE;
        int avg = total / machines.length;
        int cnt = 0;
        for(int i : machines){
            cnt += i - avg;
            max = Math.max(max, Math.max(Math.abs(cnt), i - avg));
        }
        return max;
    }
}