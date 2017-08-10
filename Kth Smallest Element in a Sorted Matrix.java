public class Solution {
    int rows, cols;
    int total;
    public int kthSmallest(int[][] matrix, int k) {
        rows = matrix.length;
        cols = matrix[0].length;
        total = rows * cols;
        kSelect(0, total - 1, matrix, k - 1);
        return get(matrix, k - 1);
    }
    public void kSelect(int L, int H, int[][] matrix, int k){
        if(L <= k && H >= k){
            int mid = get(matrix, (L + H) / 2);
            int start = L, end = H;
            do{
                while(get(matrix, start) < mid) start++;
                while(get(matrix, end) > mid) end--;
                if(start <= end){
                    int temp = get(matrix, start);
                    set(matrix, start, 
                       get(matrix, end));
                    set(matrix, end, temp);
                    start++;
                    end--;
                }
            }while(start <= end);
            if(L < end) kSelect(L, end, matrix, k);
            if(start < H) kSelect(start, H, matrix, k);
        }
    }
    public void set(int[][] matrix, int index, int value){
        int row = index / cols;
        int col = index % cols;
        matrix[row][col] = value;
    }
    public int get(int[][] matrix, int index){
        int row = index / cols;
        int col = index % cols;
        return matrix[row][col];
        
    }
}