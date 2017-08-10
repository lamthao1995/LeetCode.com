public class Solution {
    int fact[] = new int[11];
    public int countNumbersWithUniqueDigits(int n) {
        if(n > 10) return 0;
        if(n == 0) return 1;
        int trace[] = new int[11];
        fact[1] = 10; fact[2] = 9 * 9;
        for(int i = 3; i <= 10; i++){
            fact[i] = fact[i - 1] * (11 - i);
        }
        for(int i = 1; i <= n; i++){
            trace[i] = trace[i - 1] + fact[i];
        }
        return trace[n];
        
    }
   
    
}