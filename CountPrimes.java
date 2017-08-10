public class Solution {
    public int countPrimes(int n) {
       boolean[] isPrime = new boolean[n];
       Arrays.fill(isPrime, true);
       for(int i = 2; i < n; i++){
           if(isPrime[i]){
              for(int j = 2 * i; j < n; j = j + i){
                  isPrime[j] = false;
              } 
           }
       }
       int count = 0;
       for(int i = 2; i < n; i++){
           if(isPrime[i]){
               count++;
           }
       }
       return count;
    }
}