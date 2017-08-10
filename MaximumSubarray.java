public class Solution {
    public int maxSubArray(int[] nums) {
        int sum_temp = 0;
        int sum_final = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
           if(max < nums[i]) max = nums[i];
           
           sum_temp = Math.max(0, sum_temp + nums[i]);
           sum_final = Math.max(sum_temp, sum_final);
        }
        if(max < 0) return max;
        return sum_final;
    }
}