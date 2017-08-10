public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0, cur = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                cur++;
                sum += cur;
                
            }else{
                cur = 0;
            }
        }
        return sum;
    }
}