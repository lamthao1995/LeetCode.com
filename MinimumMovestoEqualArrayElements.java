public class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = nums[0];
        int len = nums.length;
        for(int i = 1; i < len; i++){
            min = min > nums[i] ? nums[i] : min;
            sum += nums[i];
        }
        return sum - min * len;
    }
}