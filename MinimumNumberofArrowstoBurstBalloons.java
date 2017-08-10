public class Solution {
    public int findMinArrowShots(int[][] points) {
        int rows = points.length;
        if(rows == 0) return 0;
        quickS(0, rows - 1, points);
        int MAX = Integer.MAX_VALUE;
        for(int i = 0; i < rows - 1; i++){
            if(points[i + 1][0] <= points[i][1]){
                points[i + 1][1] = min(points[i][1], points[i + 1][1]);
                points[i][0] = MAX;
            }
        }
        int counter = 0;
        for(int i = 0; i < rows; i++){
            if(points[i][0] != MAX) counter++;
        }
        return counter;
    }
    public int min(int a, int b){
        return a < b ? a : b;
    }
    public void quickS(int L, int H, int[][] p){
        int mid = p[(L + H) / 2][0];
        int start = L, end = H;
        do{
            while(p[start][0] < mid) start++;
            while(p[end][0] > mid) end--;
            if(end >= start){
                int temp = p[start][0];
                p[start][0] = p[end][0];
                p[end][0] = temp;
                temp = p[start][1];
                p[start][1] = p[end][1];
                p[end][1] = temp;
                end--;
                start++;
            }
        }while(start <= end);
        if(L < end) quickS(L, end, p);
        if(start < H) quickS(start, H, p);
    }
}