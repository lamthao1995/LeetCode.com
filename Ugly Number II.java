public class Solution {
    public int nthUglyNumber(int n) {
        int[] trace = new int[n];
        trace[0] = 1;
        int fact2 = 2, fact3 = 3, fact5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i = 1; i < n; i++){
            int min = min(fact2, fact3, fact5);
            trace[i] = min;
            if(fact3 == min){
                fact3 = 3 * trace[++index3];
            }
             if(fact2 == min){
                fact2 = 2 * trace[++index2];
            }
             if(fact5 == min){
                fact5 = 5 * trace[++index5];
            }
           
        }
         return trace[n - 1];
        
    }
    public int min(int a, int b, int c){
        if(a > b) a = b;
        if(a > c) a = c;
        return a;
    }
   
}