public class Solution {
    public List<Integer> grayCode(int n){
      List<Integer> arr = new ArrayList<>();
        arr.add(0);
        
        for(int i = 1; i <= n; i++){
            for(int k = arr.size() - 1; k >= 0; k--){
                arr.add(arr.get(k) + (1 << (i - 1)));
            }
        }
        return arr;
    }
}