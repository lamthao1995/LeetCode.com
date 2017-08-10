public class Solution {
    List<Integer> rs = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
 		int startR = 0, startC = 0;
        int m = matrix.length;
        if(m == 0) return rs;
        int n = matrix[0].length;
        while(2 * startR < m && 2 * startC < n){
            print(startR++, startC++, matrix, m, n);
        }
        return this.rs;
    }
    public void print(int startR, int startC, int[][] matrix, int m, int n){
        //horizontal
        for(int i = 0; i < n - 2 * startC; i++){
            rs.add(matrix[startR][i+startC]);
         ///   System.out.println("1");
        }

        for(int i = 0; i < m - 2 * startR - 1; i++){
            rs.add(matrix[i + startR + 1][n - startC - 1]);
         ///   System.out.println("2");
        }
        if(m  - startR - 1 != startR){
        for(int i = n - startC - 2; i >= startC; i--){
            rs.add(matrix[m - startR - 1][i]);
          ///  System.out.println("3");
        }}
        if(startC != n - startC - 1){
        for(int i = m - startR - 2; i > startR; i--){
            rs.add(matrix[i][startC]);
           /// System.out.println("4 "+m +" n=="+n);
        }
        }
    }
}