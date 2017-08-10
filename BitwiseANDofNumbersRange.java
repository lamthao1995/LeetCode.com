public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while(n > m){
            n = n & (n - 1);
        }
        return  n;
    }
}