public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0.0;
        if(n == 0) return 1.0;
        if(n == 1) return x;
        int posN = n > 0 ? n : -n;
        double rs = pow(x, posN);
        return n > 0 ? rs : 1 / rs;
        
       
    }
    public double pow(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double aHalf = pow(x, n / 2);
        if((n & 1) == 0){
            return aHalf * aHalf;
        }else{
            return aHalf * aHalf * x;
        }
    }
}