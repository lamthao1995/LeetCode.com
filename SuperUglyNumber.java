public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] times = new int[len];
        int rs[] = new int[n];
        rs[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                min = Math.min(min, primes[j] * rs[times[j]]);
            }
            rs[i] = min;
            for(int j = 0; j < len; j++){
                if(rs[times[j]] * primes[j] == min){
                    times[j]++;
                    //System.out.println("i = " + i + " and min = " + min);
                    //break;
                }
                    //times[j]++;
            }
        }
        return rs[n - 1];
        
    }
}