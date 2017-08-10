public class Solution {
    public final static int maxDiv10 = Integer.MAX_VALUE / 10;
    public int myAtoi(String str) {
        int cur = 0, len = str.length();
        if(len == 0) return 0;
        while(cur < len && str.charAt(cur) == ' ') cur++;
        int sign = 1;
        if(cur < len && str.charAt(cur) == '+') cur++;
        else if(str.charAt(cur) == '-'){
            sign = -1;
            cur++;
        }
        int num = 0;
        while(cur < len && Character.isDigit(str.charAt(cur))){
            int digit = Character.getNumericValue(str.charAt(cur));
            if(num > maxDiv10 || num == maxDiv10 && digit >= 8){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            cur++;
        }
        return num * sign;
    }
}