public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        int[] trace = new int[len];
        trace[0] = nums[0];
        trace[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i = 2; i < len; i++){
           int max = trace[i - 2] + nums[i];
           trace[i] = max > trace[i - 1] ? max : trace[i - 1];
        }
        return trace[len - 1];
    }
}