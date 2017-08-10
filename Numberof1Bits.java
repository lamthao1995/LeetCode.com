public class Solution {
    // you need to treat n as an unsigned value
    int total = 0;
    public int hammingWeight(int n) {
        if(n == 0) return total;
        while(n != 0){
            total++;
            n = n & (n - 1);
        }
        return total;
    }
}