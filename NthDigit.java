public class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;
        while(n > len * count){
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String s = start + "";
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}