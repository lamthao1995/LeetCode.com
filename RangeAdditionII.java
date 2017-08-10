public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = ops.length;
        if(row == 0){
            return m * n;
        }
        //System.out.println(row);
        int a = Integer.MAX_VALUE; int b = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            if(a > ops[i][0]){
                a = ops[i][0];
            }
            if(b > ops[i][1]){
                b = ops[i][1];
            }
        }
        return a * b;
    }
}