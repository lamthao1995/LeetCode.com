public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int cur = 0, left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(cur < len){
            sum += nums[cur++];
            while(sum >= s){
                min = Math.min(min, cur - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
