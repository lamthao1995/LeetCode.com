public class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int mod = num % 9;
        return mod == 0 ? 9 : mod;
    }
}