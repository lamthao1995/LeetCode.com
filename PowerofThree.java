public class Solution {
    public boolean isPowerOfThree(int n) {
        int max3 = (int) Math.pow(3, 19);
        if(n > 0 && max3 % n == 0) 
            return true;
        return false;
    }
}