public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        if(sum % 2 == 1)
            return false;
        sum /= 2;
        int len = nums.length;
        int[][] dp = new int[len + 1][sum + 1];
        
        for(int i = 0; i <= len; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(nums[i - 1] <= j){
                    dp[i][j] =  Math.max(nums[i - 1] + dp[i - 1][j - nums[i - 1]], dp[i - 1][j]);
                }
            }
        }
        //System.out.println(dp[len][sum]);
        if(dp[len][sum] != sum)
            return false;
        return true;
        
    }
}