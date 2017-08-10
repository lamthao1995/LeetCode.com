public class Solution {
    public int mySqrt(int x) {
       if(x == 1 || x == 0) return x;
       double rev = (double)(x - 1);
       while(true){
           double temp = rev;
           rev = (rev + (1.0 * x / rev)) / 2;
          // System.out.print(rev + " ");
           if((int)Math.abs(temp - rev) == 0) break;
       }
       return (int) rev;
       
    }
   
}