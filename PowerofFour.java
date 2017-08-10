public class Solution {
    public boolean isPowerOfFour(int num) {
        int n = num;
        if(num == 1) return true;
        if(num < 4) return false;
        if((n & n - 1) != 0) return false;
        int counter = 0;
        while(n != 0){
            counter++;
            n = n >> 1;
            if((n & 1) == 1) break;
        }
        if((counter & 1) == 0) return true;
        return false;
    }
}