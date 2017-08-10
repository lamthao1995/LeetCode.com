public class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[] trace = new int[len + 1];
        trace[0] = 0;
        for(int i = 0; i < len; i++){
            trace[i + 1] = trace[i] + nums[i];
        }
        int dp[] = new int[len];
        for(int i = 0; i < len; i++){
            dp[i] = trace[len] - trace[i];
        }
        for(int s = 1; s < m; s++){
            for(int i = 0; i < len - s; i++){
                dp[i] = Integer.MAX_VALUE;
                for(int j = i + 1; j <= len - s; j++){
                    int t = Math.max(dp[j], trace[j] - trace[i]);
                    if(t <= dp[i]){
                        dp[i] = t;
                    }else{
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}