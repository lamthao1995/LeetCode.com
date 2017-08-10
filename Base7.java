public class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        int sign = 1;
        if(num < 0)
            sign = -1;
        String rs = "";
        int x = Math.abs(num);
        while(x != 0){
            rs = (x % 7) + rs;
            x = x / 7;
        }
        if(sign == - 1)
            rs = "-" + rs;
        return rs;
    }
}