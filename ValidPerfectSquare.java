public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 1) return false;
        if(num == 1) return true;
        long t = num / 2;
        while(t * t > num){
            t = (t + (long)num / t) / 2;
        }
        return t * t == (long)num;
    }
}