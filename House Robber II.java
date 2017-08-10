public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max1 = rob(nums, 0, nums.length - 2);
        int max2 = rob(nums, 1, nums.length - 1);
        return max1 > max2 ? max1 : max2;
    }
    public int rob(int[] nums, int start, int end) {
        int len = end - start + 1;  
        int[] trace = new int[len];
        if(len <= 0) return 0;
        if(len == 1) return nums[start];
        trace[0] = nums[start];
        trace[1] = nums[start] > nums[start + 1] ? nums[start] : nums[start + 1];
        for(int i = 2; i < len; i++){
            int max = trace[i - 2] + nums[start + i];
            trace[i] =  max > trace[i - 1] ? max : trace[i - 1];
        }
        return trace[len - 1];
    }
}