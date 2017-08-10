public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r * c != nums.length * nums[0].length)
            return nums;
        int numberOfE = nums.length * nums[0].length;
        int count = 0;
        int[][] rs = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int[] cor = getIndex(count++, nums[0].length);
                rs[i][j] = nums[cor[0]][cor[1]];
            }
        }
        return rs;
    }
    public int[] getIndex(int n, int cols){
        return new int[]{n / cols, n % cols};
    }
}