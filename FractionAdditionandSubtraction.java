public class Solution {
    public String fractionAddition(String expression) {
        int start = 0, len = expression.length();
        int denominatorS = 1, numeratorS = 0;
        while(start < len){
            int sign = 1;
            if(expression.charAt(start) == '-'){
                sign = -1;
                start++;
            }else if(expression.charAt(start) == '+'){
                start++;
            }
            String numer = "";
            while(start < len && Character.isDigit(expression.charAt(start))){
                numer = numer + expression.charAt(start++);
            }
            start++;
            String deno = "";
            while(start < len && Character.isDigit(expression.charAt(start))){
                deno = deno + expression.charAt(start++);
            }
            int numerator = sign * Integer.parseInt(numer);
            int denominator = Integer.parseInt(deno);
            int gcd = Math.abs(GCD(denominatorS * numerator + numeratorS * denominator, denominator * denominatorS));
            numeratorS = (denominatorS * numerator + numeratorS * denominator) / gcd;
            denominatorS = (denominatorS * denominator) / gcd;
        }
        return numeratorS + "/" + denominatorS;
    }
    public static int GCD(int x, int y){
        return y == 0 ? x : GCD(y, x % y);
    }
}