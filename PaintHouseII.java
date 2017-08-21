public class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int preMin = 0, preSecond = 0;
        int preIndex = -1;
        for(int i = 0; i < costs.length; i++){
            int curMin = Integer.MAX_VALUE, curSecond = curMin;
            int curIndex = 0;
            for(int j = 0; j < costs[0].length; j++){
                if(preIndex == j){
                    costs[i][j] += preSecond;
                }else{
                    costs[i][j] += preMin;
                }
                
                if(curMin > costs[i][j]){
                    curSecond = curMin;
                    curMin = costs[i][j];
                    curIndex = j;
                }else if(curSecond > costs[i][j]){
                    curSecond = costs[i][j];
                }
            }
            preMin = curMin;
            preSecond = curSecond;
            preIndex = curIndex;
        }
        int result = Integer.MAX_VALUE;
        for(int j = 0; j < costs[0].length; j++){
           result = Math.min(result, costs[costs.length - 1][j]);
        }
        return result;
    }
}