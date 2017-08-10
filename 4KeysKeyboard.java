public class Solution {
    public int maxA(int N) {
        if(N <= 6)
            return N;
        int max = 0;
        for(int b = N - 3; b >= 1; b--){
            int cur = (N - b - 1) * maxA(b);
            if(cur > max)
                max = cur;
        }
        return max;
    }
}