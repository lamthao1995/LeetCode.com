public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      //  Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum) + 1);
                }else{
                    map.put(sum, 1);
                }
            }
        }
        int counter = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int sum = D[j] + C[i];
                if(map.containsKey(-sum)){
                    counter += map.get(-sum);
                }
                    //counter++;
            }
        }
        return counter;
    }
}