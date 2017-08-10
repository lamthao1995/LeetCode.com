public class Solution {
    public int reverse(int x) {
        long rs = 0;
        long absOfx = (long)Math.abs((long)x);
        while(absOfx != 0){
            rs = 10 * rs + absOfx % 10;
            absOfx /= 10;
        }
        if(rs > Integer.MAX_VALUE) return 0;
        if(x <= 0) return (int)rs * -1;
        return (int)rs;
    }
}