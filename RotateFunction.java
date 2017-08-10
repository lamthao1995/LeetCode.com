public class Solution {
    public int maxRotateFunction(int[] A) {
        int numOfE = A.length;
        int sum = 0, candidate = 0;
        for(int i = 0; i < numOfE; i++){
            sum += A[i];
            candidate += A[i] * i;
        }
        int best = candidate;
        for(int i = numOfE - 1; i >= 0; i--){
            candidate = candidate + sum - A[i] * numOfE;
            best = Math.max(best, candidate);
        }
        return best;
    }
}