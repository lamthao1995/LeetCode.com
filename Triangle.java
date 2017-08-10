public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if(len == 1) return triangle.get(0).get(0);
        List<Integer> prev = triangle.get(0);
        int count = 1;
        while(count < len){
            List<Integer> cur = triangle.get(count);
            cur.set(0, prev.get(0) + cur.get(0));
            int size = cur.size();
            for(int i = 1 ; i < size - 1; i++){
                int tmp = cur.get(i);
                cur.set(i, min(tmp + prev.get(i), tmp + prev.get(i - 1)));
            }
            cur.set(size - 1, prev.get(size - 2) + cur.get(size - 1));
            prev = cur;
            count++;
        }
        List<Integer> maxArr = triangle.get(len - 1);
        int min = maxArr.get(0);
        for(int x : maxArr){
            if(x < min)
                min = x;
        }
        return min;
        
    }
    public int min(int a, int b){
        return a < b ? a : b;
    }
}