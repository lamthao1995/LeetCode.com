public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int m = costs.length - 1;
        int[][] costDp = costs.clone();
        for(int i = 1; i <= m; i++){
            costDp[i][0] += Math.min(costDp[i - 1][1], costDp[i - 1][2]);
            costDp[i][1] += Math.min(costDp[i - 1][0], costDp[i - 1][2]);
            costDp[i][2] += Math.min(costDp[i - 1][0], costDp[i - 1][1]);
        }
        return min(costDp[m][0], costDp[m][1], costDp[m][2]);
    }
    public static int min(int a, int b, int c){
        if(a > b)
            a = b;
        if(a > c)
            a = c;
        return a;
    }
}