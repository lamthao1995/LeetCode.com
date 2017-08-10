public class Solution {
    public int minSteps(int n) {
       if(n == 1)
           return 0;
        if(n <= 5)
            return n;
        int count  = 0;
        int a = 2;
        while(a * a <= n){
            while(n % a == 0){
                n = n / a;
                count += a;
            }
            a++;
        }
        if(n > 1)
            count += n;
        return count;
        
    }
}