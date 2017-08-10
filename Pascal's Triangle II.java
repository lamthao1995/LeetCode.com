public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            arr.add(0);
        }
        arr.set(0, 1);
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                arr.set(j, arr.get(j) + arr.get(j - 1));
            }
        }
      //  arr.set(rowIndex, 1);
        return arr;
    }
}