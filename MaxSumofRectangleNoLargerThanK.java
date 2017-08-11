public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return 0;
        int col = matrix[0].length;
        int m = Math.min(row, col);
        int n = Math.max(row, col);
        boolean colIsBig = col > row;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            int[] arr = new int[n];
            for(int j = i; j >= 0; j--){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for(int k = 0; k < n; k++){
                    arr[k] += colIsBig ? matrix[j][k] : matrix[k][j];
                    val += arr[k];
                    Integer subres = set.ceiling(val - target);
                    if(subres != null){
                        res = Math.max(res, val - subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}