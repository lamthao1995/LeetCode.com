public class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> arr = new ArrayList<>();
        if(numRows == 0) return arr;
       
        List<Integer> temp = new ArrayList<>();
        
        temp.add(1);
        arr.add(temp);
        for(int i = 1; i < numRows; i++){
            temp = arr.get(i - 1);
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for(int j = 1; j < temp.size(); j++){
                tmp.add(tmp.size(), temp.get(j) + temp.get(j - 1));
            }
            tmp.add(tmp.size(), 1);
            arr.add(tmp);
        }
        
        return arr;
    }
}